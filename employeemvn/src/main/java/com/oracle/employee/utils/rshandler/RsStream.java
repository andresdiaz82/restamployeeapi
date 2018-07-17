package com.oracle.employee.utils.rshandler;

import java.lang.reflect.Proxy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.stream.Stream;

public class RsStream<EmployeeDTO> {
//Stream factory using a proxy object to provide a placeholder for the actual resulting stream
	@SuppressWarnings("unchecked")
	public Stream<EmployeeDTO> getStream(PreparedStatement st, 
				Function<ResultSet, EmployeeDTO> mapFunction) throws SQLException{
		final RsStreamInvocationHandler<EmployeeDTO> handler = new RsStreamInvocationHandler<>();
		handler.setup(st, mapFunction);
		Stream<EmployeeDTO> str = (Stream<EmployeeDTO>) 
			Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] {Stream.class}, handler);
		return str;
	}
}
