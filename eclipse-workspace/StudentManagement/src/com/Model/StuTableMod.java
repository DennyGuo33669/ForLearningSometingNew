package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class StuTableMod extends AbstractTableModel{

	private Vector<String> colunmNames=null;
	private Vector hang=null;
	private Vector RowData=null;
	private List<String> stuNo=null;
	private List<String> classNo=null;
	private List<String> className=null;
	private List<String> creditHour;
	private List<String> regularScore;
	private List<String> experimentalScore;
	private  List<String> examinationScore;
	private List<String> comprehensiveScore;
	private List<String> realCredit;
	public StuTableMod() {

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

				TableData tb = new TableData();
				stuNo = tb.stuNo;
				classNo = tb.classNo;
				className = tb.className;
				creditHour = tb.creditHour;
				regularScore = tb.regularScore;
				experimentalScore = tb.experimentalScore;
				examinationScore = tb.examinationScore;
				comprehensiveScore = tb.comprehensiveScore;
				realCredit = tb.realCredit;
				RowData=new Vector();
				
		for(int i = 0;i<tb.stuNo.size();i++) {
						hang=new Vector();
						hang.add(stuNo.get(i));
						hang.add(classNo.get(i));
						hang.add(className.get(i));
						hang.add(creditHour.get(i));
						hang.add(regularScore.get(i));
						hang.add(experimentalScore.get(i));
						hang.add(examinationScore.get(i));
						hang.add(comprehensiveScore.get(i));
						hang.add(realCredit.get(i));
//						System.out.println(hang);
						RowData.add(hang);
					}
					

				
			}
	
	 
	 
		public StuTableMod(String name) {
		//或这个这个
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

				TableData tb = new TableData();
				stuNo = tb.stuNo;
				classNo = tb.classNo;
				className = tb.className;
				creditHour = tb.creditHour;
				regularScore = tb.regularScore;
				experimentalScore = tb.experimentalScore;
				examinationScore = tb.examinationScore;
				comprehensiveScore = tb.comprehensiveScore;
				realCredit = tb.realCredit;
				RowData=new Vector();
				
		for(int i = 0;i<tb.stuNo.size();i++) {
						hang=new Vector();
						hang.add(stuNo.get(i));
						hang.add(classNo.get(i));
						hang.add(className.get(i));
						hang.add(creditHour.get(i));
						hang.add(regularScore.get(i));
						hang.add(experimentalScore.get(i));
						hang.add(examinationScore.get(i));
						hang.add(comprehensiveScore.get(i));
						hang.add(realCredit.get(i));
//						System.out.println(hang);
						RowData.add(hang);
					}
					

				
			}
//	
//	public StuTableMod(String stuNo) {
//
//			colunmNames=new Vector<String>();
//			colunmNames.add("学号");
//			colunmNames.add("课程编号");
//			colunmNames.add("课程名称");
//			colunmNames.add("学分");
//			colunmNames.add("平时成绩");
//			colunmNames.add("实验成绩");
//			colunmNames.add("卷面成绩");
//			colunmNames.add("综合成绩");
//			colunmNames.add("实得学分");
//
//
//				RowData=new Vector();
//				hang=new Vector();
//				hang.add(stuNo);
//				hang.add(classNo);
//				hang.add(className);
//				hang.add(creditHour);
//				hang.add(regularScore);
//				hang.add(experimentalScore);
//				hang.add(examinationScore);
//				hang.add(comprehensiveScore);
//				hang.add(realCredit);
//				
//				RowData.add(hang);
//					
//					RowData.add(hang);
//				
//
//		}
//		
	
	@Override
	public int getColumnCount() {		
		return this.colunmNames.size();
	}

	@Override
	public int getRowCount() {
//		System.out.println("row="+this.RowData.size());
		return this.RowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		return ((Vector)this.RowData.get(row)).get(col);
	}
	@Override
	public String getColumnName(int column) {
		
		return this.colunmNames.get(column);
	}
	
}
