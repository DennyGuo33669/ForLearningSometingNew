package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import com.Dao.*;
public class TableMod extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private SqlConnection sqlConnection=null;
//	private Connection connection=null;
	private Vector<String> colunmNames=null;
	@SuppressWarnings("rawtypes")
	private Vector hang=null;
	@SuppressWarnings("rawtypes")
	private Vector RowData=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableMod() {
//		sqlConnection=SqlConnection.getInstace();
//		sqlConnection.init();
		colunmNames=new Vector<String>();
		colunmNames.add("学号");
		colunmNames.add("课程编号");
		colunmNames.add("课程名称");
		colunmNames.add("学分");
		colunmNames.add("平时成绩");
		colunmNames.add("实验成绩");
		colunmNames.add("卷面成绩");
		colunmNames.add("综合成绩");
		colunmNames.add("实得学分");
		connection=sqlConnection.getConnection();
		try {
//			preparedStatement=connection.prepareStatement("select * from score");
//			resultSet=preparedStatement.executeQuery();
//			sqlConnection.setConnection(connection);
//			sqlConnection.setPreparedStatement(preparedStatement);
//			sqlConnection.setResultSet(resultSet);
			RowData=new Vector();
			while(resultSet.next()) {
				hang=new Vector();
				hang.add(resultSet.getObject(1));
				hang.add(resultSet.getObject(2));
				hang.add(resultSet.getObject(3));
				hang.add(resultSet.getObject(4));
				hang.add(resultSet.getObject(5));
				hang.add(resultSet.getObject(6));
				hang.add(resultSet.getObject(7));
				hang.add(resultSet.getObject(8));
				hang.add(resultSet.getObject(9));
				
				RowData.add(hang);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			sqlConnection.close();
		}
		
	}
	
	public TableMod(String stuNo) {
		
//			sqlConnection=SqlConnection.getInstace();
//			sqlConnection.init();
			colunmNames=new Vector<String>();
			colunmNames.add("学号");
			colunmNames.add("课程编号");
			colunmNames.add("课程名称");
			colunmNames.add("学分");
			colunmNames.add("平时成绩");
			colunmNames.add("实验成绩");
			colunmNames.add("卷面成绩");
			colunmNames.add("综合成绩");
			colunmNames.add("实得学分");
//			connection=sqlConnection.getConnection();
			try {
//				preparedStatement=connection.prepareStatement("select * from score where stuNo=?");
//				preparedStatement.setObject(1, stuNo);
//				resultSet=preparedStatement.executeQuery();
//				sqlConnection.setConnection(connection);
//				sqlConnection.setPreparedStatement(preparedStatement);
//				sqlConnection.setResultSet(resultSet);
				RowData=new Vector();
				while(resultSet.next()) {
					hang=new Vector();
					hang.add(resultSet.getObject(1));
					hang.add(resultSet.getObject(2));
					hang.add(resultSet.getObject(3));
					hang.add(resultSet.getObject(4));
					hang.add(resultSet.getObject(5));
					hang.add(resultSet.getObject(6));
					hang.add(resultSet.getObject(7));
					hang.add(resultSet.getObject(8));
					hang.add(resultSet.getObject(9));
					
					RowData.add(hang);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
//				sqlConnection.close();
			}
			
		}
		
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return this.colunmNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.RowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return ((Vector)this.RowData.get(row)).get(col);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		
		
		return this.colunmNames.get(column);
	}

}
