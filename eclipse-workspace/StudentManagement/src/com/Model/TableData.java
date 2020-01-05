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
		// 连接数据库
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("mycol");
		MongoCollection<Document> doc = db.getCollection("score");

		// 获取数据库内账号&密码
		List<String> list = new ArrayList<String>();

		FindIterable<Document> iter = doc.find()
				.projection(new BasicDBObject().append("学号", 1).append("课程编号", 2).append("课程名称", 3).append("学分", 4)
						.append("平时成绩", 5).append("实验成绩", 6).append("卷面成绩", 7).append("综合成绩", 8).append("实得学分", 9)

				);

		List<Document> resultList = new ArrayList<>();

		// 查询结果块。Document类型
		Block<Document> block = new Block<Document>() {
			// 调用,将每一个Document传入此中
			@Override
			public void apply(Document t) {
				resultList.add(t);
			}
		};

		iter.forEach(block);
for(int i = 0;i<resultList.size();i++) {

	// 解析JSON数据
	JSONObject jsonObject = JSONObject.parseObject(resultList.get(i).toJson());
	stuNo.add(jsonObject.getString("学号"));
	classNo.add(jsonObject.getString("课程编号"));
	className.add(jsonObject.getString("课程名称"));
	creditHour.add(jsonObject.getString("学分"));
	regularScore.add(jsonObject.getString("平时成绩"));
	experimentalScore.add(jsonObject.getString("实验成绩"));
	examinationScore.add(jsonObject.getString("卷面成绩"));
	comprehensiveScore.add(jsonObject.getString("综合成绩"));
	realCredit.add(jsonObject.getString("实得学分"));
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
