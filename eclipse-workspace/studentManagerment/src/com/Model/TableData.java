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

		// ����JSON����
		JSONObject jsonObject = JSONObject.parseObject(resultList.get(0).toJson());
		Student student = new Student();
		student.setStuNo(jsonObject.getString("ѧ��"));
		student.setClassNo(jsonObject.getString("�γ̱��"));
		student.setClassName(jsonObject.getString("�γ�����"));
		student.setCreditHour(Double.valueOf(jsonObject.getString("ѧ��")));
		student.setRregularScore(Double.valueOf(jsonObject.getString("ƽʱ�ɼ�")));
		student.setExperimentalScore(Double.valueOf(jsonObject.getString("ʵ��ɼ�")));
		student.setExaminationScore(Double.valueOf(jsonObject.getString("����ɼ�")));
		if (jsonObject.getString("�ۺϳɼ�").equals("")) {
			student.setComprehensiveScore(0);
		} else {
			student.setComprehensiveScore(Double.valueOf(jsonObject.getString("�ۺϳɼ�")));

		}

		if (jsonObject.getString("ʵ��ѧ��").equals("")) {
			student.setRealcredit(0);
		} else {
			student.setRealcredit(Double.valueOf(jsonObject.getString("ʵ��ѧ��")));
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
