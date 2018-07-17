package com.oracle.employee.utils.rshandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*Took me some time as i was investigating how to handle a resultset as a stream for better
 *  performance this pattern creates an invocation handler with a resultset provider to populate the stream 
 *  after executing the query by mapping the fields to the dto object*/

public class RsStreamInvocationHandler<EmployeeDTO> implements InvocationHandler{
	 
	  private Stream<EmployeeDTO> stream; // proxy will intercept method calls to such stream
	  private PreparedStatement st;
	  private ResultSet rs;
	 
	  public void setup(PreparedStatement st, Function<ResultSet, EmployeeDTO> mapFunction)
	  throws SQLException{
	    this.st = st;
	    rs = st.executeQuery();
	    stream = Stream.generate(new ResultSetSupplier(rs, mapFunction));
	  }
	 
	  @Override
	  public Object invoke(Object proxy, Method method, Object[] args)
	  throws Throwable {
	 
	    if (method == null)
	      throw new RuntimeException("RuntimeException null method null");
	 
	    // AutoCloseable for PreparedStatement
	    if (method.getName().equals("close") && args == null){
	    // invoked close(), no arguments
	      if (st != null){
	        st.close(); // closes ResultSet too
	      }
	    }
	 
	    return method.invoke(stream, args);
	  }
	 
	private class ResultSetSupplier implements Supplier<EmployeeDTO>{
	 
	  private final ResultSet rs;
	  private final Function<ResultSet, EmployeeDTO> mapFunction;
	 
	  private ResultSetSupplier(ResultSet rs, Function<ResultSet, EmployeeDTO> mapFunction) {
	    this.rs = rs;
	    this.mapFunction = mapFunction;
	  }
	 
	  @Override
	  public EmployeeDTO get() {
	    try {
	      if (rs.next())
	        return mapFunction.apply(rs);
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	    return null;
	  }
	}
	 
	}