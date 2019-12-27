package com.service;
import java.sql.*;
import com.Dao.*;
import com.domain.*;
public class stuService {
	private String sql=null;
	private SqlConnection sqlConnection=null;
	private Connection connection=null;
	private PreparedStatement preparedStatement =null;
	
	public void insertStu(Student student) {
		sql="insert into score values(?,?,?,?,?,?,?,?,?)";
		sqlConnection=SqlConnection.getInstace();
		sqlConnection.init();
		connection=sqlConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement(sql);
			
			
			preparedStatement.setObject(1, student.getStuNo());
			preparedStatement.setObject(2, student.getClassNo());
			preparedStatement.setObject(3, student.getClassName());
			preparedStatement.setObject(4, student.getCredit_Hour());
			preparedStatement.setObject(5, student.getCredit1());
			preparedStatement.setObject(6, student.getCredit2());
			preparedStatement.setObject(7, student.getCredit3());
			preparedStatement.setObject(8, student.getAll_credit());
			preparedStatement.setObject(9, student.getReal_credit());
			
			
			preparedStatement.executeUpdate();
			sqlConnection.setConnection(connection);
			sqlConnection.setPreparedStatement(preparedStatement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlConnection.close();
			
		}
		
	}
}
