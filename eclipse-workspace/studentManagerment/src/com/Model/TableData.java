package com.Model;

import java.util.ArrayList;
import java.util.List;

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

		// 解析JSON数据
		JSONObject jsonObject = JSONObject.parseObject(resultList.get(0).toJson());
		Student student = new Student();
		student.setStuNo(jsonObject.getString("学号"));
		student.setClassNo(jsonObject.getString("课程编号"));
		student.setClassName(jsonObject.getString("课程名称"));
		student.setCreditHour(Double.valueOf(jsonObject.getString("学分")));
		student.setRregularScore(Double.valueOf(jsonObject.getString("平时成绩")));
		student.setExperimentalScore(Double.valueOf(jsonObject.getString("实验成绩")));
		student.setExaminationScore(Double.valueOf(jsonObject.getString("卷面成绩")));
		if (jsonObject.getString("综合成绩").equals("")) {
			student.setComprehensiveScore(0);
		} else {
			student.setComprehensiveScore(Double.valueOf(jsonObject.getString("综合成绩")));

		}

		if (jsonObject.getString("实得学分").equals("")) {
			student.setRealcredit(0);
		} else {
			student.setRealcredit(Double.valueOf(jsonObject.getString("实得学分")));
		}

		System.out.println(student.getStuNo() + " | " + student.getClassNo() + " | " + student.getClassName() + " | "
				+ student.getCreditHour() + " | " + student.getRregularScore() + " | " + student.getExperimentalScore()
				+ " | " + student.getExaminationScore() + " | " + student.getComprehensiveScore() + " | "
				+ student.getRealcredit());

	}

	public static void main(String[] args) {
		new TableData();

	}

}
