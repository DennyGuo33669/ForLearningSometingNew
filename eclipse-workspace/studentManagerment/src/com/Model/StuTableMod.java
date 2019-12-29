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
		colunmNames.add("ѧ��");
		colunmNames.add("�γ̱��");
		colunmNames.add("�γ�����");
		colunmNames.add("ѧ��");
		colunmNames.add("ƽʱ�ɼ�");
		colunmNames.add("ʵ��ɼ�");
		colunmNames.add("����ɼ�");
		colunmNames.add("�ۺϳɼ�");
		colunmNames.add("ʵ��ѧ��");



//			// �������ݿ�
//			MongoClient mongoClient = new MongoClient("localhost", 27017);
//			MongoDatabase db = mongoClient.getDatabase("mycol");
//			MongoCollection<Document> doc = db.getCollection("score");
//			
//			//��ȡ���ݿ����˺�&����
//			List<String> list = new ArrayList<String>();
////			list.add(key);
//			list.add("ѧ��");
//			FindIterable<Document> iter = doc.find(new Document("ѧ��", new Document("$in", list)));
//			iter.forEach(new Block<Document>() {
//				public void apply(Document _doc) {
//					System.out.println(_doc.toJson());
//					stuNo=_doc.getString("ѧ��");;
//					classNo=_doc.getString("�γ̱��");;
//					className=_doc.getString("�γ�����");;
//					creditHour=Double.valueOf(_doc.getString("ѧ��"));
//					regularScore=Double.valueOf(_doc.getString("ƽʱ�ɼ�"));
//					experimentalScore=Double.valueOf(_doc.getString("ʵ��ɼ�"));
//					examinationScore=Double.valueOf(_doc.getString("����ɼ�"));
//					comprehensiveScore=Double.valueOf(_doc.getString("�ۺϳɼ�"));
//					realCredit=Double.valueOf(_doc.getString("ʵ��ѧ��"));
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
			colunmNames.add("ѧ��");
			colunmNames.add("�γ̱��");
			colunmNames.add("�γ�����");
			colunmNames.add("ѧ��");
			colunmNames.add("ƽʱ�ɼ�");
			colunmNames.add("ʵ��ɼ�");
			colunmNames.add("����ɼ�");
			colunmNames.add("�ۺϳɼ�");
			colunmNames.add("ʵ��ѧ��");


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
