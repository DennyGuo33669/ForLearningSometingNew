package com.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.bson.Document;

import com.domain.*;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TableData {
	private List<String> tbValue = new ArrayList<String>();
	 List<String> stuNo = new ArrayList<String>();
	 List<String> classNo = new ArrayList<String>();
	 List<String> className = new ArrayList<String>();
	 List<String> creditHour = new ArrayList<String>();
	 List<String> regularScore = new ArrayList<String>();
	 List<String> experimentalScore = new ArrayList<String>();
	 List<String> examinationScore = new ArrayList<String>();
	 List<String> comprehensiveScore = new ArrayList<String>();
	 List<String> realCredit = new ArrayList<String>();

	
	public TableData() {
		// �������ݿ�
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("mycol");
		MongoCollection<Document> doc = db.getCollection("score");

		// ��ȡ���ݿ����˺�&����
		List<String> list = new ArrayList<String>();

		FindIterable<Document> iter = doc.find()
				.projection(new BasicDBObject().append("ѧ��", 1).append("�γ̱��", 2).append("�γ�����", 3).append("ѧ��", 4)
						.append("ƽʱ�ɼ�", 5).append("ʵ��ɼ�", 6).append("����ɼ�", 7).append("�ۺϳɼ�", 8).append("ʵ��ѧ��", 9)

				);

		List<Document> resultList = new ArrayList<>();

		// ��ѯ����顣Document����
		Block<Document> block = new Block<Document>() {
			// ����,��ÿһ��Document�������
			@Override
			public void apply(Document t) {
				resultList.add(t);
			}
		};

		iter.forEach(block);
for(int i = 0;i<resultList.size();i++) {

	// ����JSON����
	JSONObject jsonObject = JSONObject.parseObject(resultList.get(i).toJson());
	stuNo.add(jsonObject.getString("ѧ��"));
	classNo.add(jsonObject.getString("�γ̱��"));
	className.add(jsonObject.getString("�γ�����"));
	creditHour.add(jsonObject.getString("ѧ��"));
	regularScore.add(jsonObject.getString("ƽʱ�ɼ�"));
	experimentalScore.add(jsonObject.getString("ʵ��ɼ�"));
	examinationScore.add(jsonObject.getString("����ɼ�"));
	comprehensiveScore.add(jsonObject.getString("�ۺϳɼ�"));
	realCredit.add(jsonObject.getString("ʵ��ѧ��"));
	System.out.println(stuNo.get(i));

}


System.out.println(tbValue);
	}

	public List getTbValue() {

		return tbValue;
	}
	
	
	
	
//	
//	
//	public String getStuNo() {
//		return stuNo;
//	}
//	public void setStuNo(String stuNo) {
//		this.stuNo = stuNo;
//	}
//	public String getClassNo() {
//		return classNo;
//	}
//	public void setClassNo(String classNo) {
//		this.classNo = classNo;
//	}
//	public String getClassName() {
//		return className;
//	}
//	public void setClassName(String className) {
//		this.className = className;
//	}
//	public String getCreditHour() {
//		return creditHour;
//	}
//	public void setCreditHour(String creditHour) {
//		this.creditHour = creditHour;
//	}
//	public String getRregularScore() {
//		return regularScore;
//	}
//	public void setRregularScore(String regularScore) {
//		this.regularScore = regularScore;
//	}
//	public String getExperimentalScore() {
//		return experimentalScore;
//	}
//	public void setExperimentalScore(String experimentalScore) {
//		this.experimentalScore = experimentalScore;
//	}
//	public String getExaminationScore() {
//		return examinationScore;
//	}
//	public void setExaminationScore(String examinationScore) {
//		this.examinationScore = examinationScore;
//	}
//	public String getComprehensiveScore() {
//		return comprehensiveScore;
//	}
//	public void setComprehensiveScore(String comprehensiveScore) {
//		this.comprehensiveScore = comprehensiveScore;
//	}
//	public String getRealcredit() {
//		return realCredit;
//	}
//	public void setRealcredit(String realCredit) {
//		this.realCredit = realCredit;
//	}
	public static void main(String[] args) {
		new TableData();

	}

}
