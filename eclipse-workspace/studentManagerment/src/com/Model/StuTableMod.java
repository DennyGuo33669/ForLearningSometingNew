package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

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
	private String stuNo=null;
	private String classNo=null;
	private String className=null;
	private double creditHour;
	private double regularScore;
	private double experimentalScore;
	private double examinationScore;
	private double comprehensiveScore;
	private double realCredit;
	
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



//			// 连接数据库
//			MongoClient mongoClient = new MongoClient("localhost", 27017);
//			MongoDatabase db = mongoClient.getDatabase("mycol");
//			MongoCollection<Document> doc = db.getCollection("score");
//			
//			//获取数据库内账号&密码
//			List<String> list = new ArrayList<String>();
////			list.add(key);
//			list.add("学号");
//			FindIterable<Document> iter = doc.find(new Document("学号", new Document("$in", list)));
//			iter.forEach(new Block<Document>() {
//				public void apply(Document _doc) {
//					System.out.println(_doc.toJson());
//					stuNo=_doc.getString("学号");;
//					classNo=_doc.getString("课程编号");;
//					className=_doc.getString("课程名称");;
//					creditHour=Double.valueOf(_doc.getString("学分"));
//					regularScore=Double.valueOf(_doc.getString("平时成绩"));
//					experimentalScore=Double.valueOf(_doc.getString("实验成绩"));
//					examinationScore=Double.valueOf(_doc.getString("卷面成绩"));
//					comprehensiveScore=Double.valueOf(_doc.getString("综合成绩"));
//					realCredit=Double.valueOf(_doc.getString("实得学分"));
//				}
//			});
//			
			RowData=new Vector();
//			while() {
				hang=new Vector();
				hang.add(stuNo);
				hang.add(classNo);
				hang.add(className);
				hang.add(creditHour);
				hang.add(regularScore);
				hang.add(experimentalScore);
				hang.add(examinationScore);
				hang.add(comprehensiveScore);
				hang.add(realCredit);
				
				RowData.add(hang);
//			}
			

		
	}
	
	public StuTableMod(String stuNo) {

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


				RowData=new Vector();
//				while(resultSet.next()) {
					hang=new Vector();
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					hang.add(1);
					
					RowData.add(hang);
//				}

		}
		
	
	@Override
	public int getColumnCount() {		
		return this.colunmNames.size();
	}

	@Override
	public int getRowCount() {
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
