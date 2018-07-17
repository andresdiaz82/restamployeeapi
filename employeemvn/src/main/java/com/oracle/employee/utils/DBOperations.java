package com.oracle.employee.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.oracle.employee.dto.EmployeeDTO;
import com.oracle.employee.enums.DBOperation;
import com.oracle.employee.utils.rshandler.RsStream;
//Basic class for performing db CRUD operations
public class DBOperations {

	public List<EmployeeDTO> executeDBOperation(DBOperation operation, EmployeeDTO emp) throws Exception,SQLException {
		List<EmployeeDTO> result = null;
		DBConnector conn = null;
		try {
			conn = DBConnector.getInstance();
			if(conn.isConnected()) {
				switch(operation) {
					case CREATE:
						break;
					case READ: //Only call read method to find all active empoyees to showcase stream usage with resultset
						result = findAllActive(conn);
						break;
					case UPDATE: //Update is never called in this app, just for showcasing purpose i added this method
						if(updateEmployee(conn, emp)) {
							result = new ArrayList<EmployeeDTO>();
							result.add(emp);
						}else {
							throw new Exception("Error while updating employee");
						}
						break;
					case DELETE:
						break;
				}
			}
			else {
				throw new SQLException("Failed to obtain connection");
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private List<EmployeeDTO> findAllActive(DBConnector conn) throws Exception, SQLException {
		String selectStatement = "Select * From employee";
		PreparedStatement stmt = conn.getConnection().prepareStatement(selectStatement);
		List<EmployeeDTO> emps = new ArrayList<>();
		try(Stream<EmployeeDTO> stream = new RsStream<EmployeeDTO>().getStream(stmt, 
				(ResultSet rs)->{try{
					return populateDTO(rs); 
				}catch(Exception s) {
					return null;
				}})){
			Iterator<EmployeeDTO> it = stream.filter(emp->1==emp.getState()).iterator();
			while(it.hasNext()) {
				emps.add(it.next());
			}
		}catch(Exception e) {
			if(emps.size() == 0)
				throw new Exception("Errors while retrieving employees");
		}
		return emps;
	}
	
	private boolean updateEmployee(DBConnector conn, EmployeeDTO emp) {
		StringBuilder updateStatement = new StringBuilder("Update employee set ");
		int paramCount = 0;
		StringBuilder values = new StringBuilder("");
		Map<Integer,Object> paramsMap = new HashMap<>();
		PreparedStatement ps = null;
		try {
		if(emp.getName() != null && !emp.getName().equals("")) {
			values.append("name = ?");
			paramCount++;
			paramsMap.put(paramCount, emp.getName());
		}
		if(emp.getMiddleInitial() != null && !emp.getMiddleInitial().equals("")) {
			if(!values.toString().equals("")) {
				values.append(", ");
			}
			values.append("middle_initial = ?");
			paramCount++;
			paramsMap.put(paramCount, emp.getMiddleInitial());
		}
		if(emp.getLastName() != null && !emp.getLastName().equals("")) {
			if(!values.toString().equals("")) {
				values.append(", ");
			}
			values.append("last_name = ?");
			paramCount++;
			paramsMap.put(paramCount, emp.getLastName());
		}
		if(emp.getDateOfBirth() != null) {
			if(!values.toString().equals("")) {
				values.append(", ");
			}
			values.append("date_of_birth = ?");
			paramCount++;
			paramsMap.put(paramCount, emp.getDateOfBirth());
		}
		if(emp.getDateOfEMployment() != null) {
			if(!values.toString().equals("")) {
				values.append(", ");
			}
			values.append("date_of_employment = ?");
			paramCount++;
			paramsMap.put(paramCount, emp.getDateOfEMployment());
		}
		
		updateStatement.append(values);
		updateStatement.append(" where id = ?");
		
		ps = conn.getConnection().prepareStatement(updateStatement.toString());
		
		for(Integer param:paramsMap.keySet()) {
			Object arg = paramsMap.get(param);
			if(arg instanceof Integer) {
				ps.setInt(param, (Integer) arg);
			}else if(arg instanceof String) {
				ps.setString(param, (String) arg);
			}else if(arg instanceof LocalDateTime) {
				ps.setTimestamp(param, Timestamp.valueOf((LocalDateTime) arg));
			}
		}
		paramCount++;
		ps.setInt(paramCount, emp.getId());
		ps.executeUpdate();
		ps.close();
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	protected EmployeeDTO populateDTO(ResultSet r) throws Exception{
		Date d = null;
		Date d1 = null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		EmployeeDTO employee = new EmployeeDTO();
		employee.setId(r.getInt("id"));
		employee.setName(r.getString("name"));
		employee.setMiddleInitial(r.getString("middle_initial"));
		employee.setLastName(r.getString("last_name"));
		d = new Date();
		d.setTime(r.getTimestamp("date_of_birth").getTime());
		employee.setDateOfBirth(df.format(d));
		d1 = new Date();
		d1.setTime(r.getTimestamp("date_of_employment").getTime());
		employee.setDateOfEMployment(df.format(d1));
		employee.setState(r.getInt("state"));
		return employee;
	}
}
