package com.service;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.domain.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class stuService {

	public void insertStu(Student student) {

		//保留小数点1位
		DecimalFormat df = new DecimalFormat("#.0"); 
		
		df.format(student.getRealcredit());
		// 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
        System.out.println("Connect to database successfully");
        
        // 选择集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("score");
        System.out.println("集合 score 选择成功");
        
        // 插入文档  
        Document document = new Document("学号", student.getStuNo()).  
        append("课程编号", student.getClassNo()).  
        append("课程名称", student.getClassName()).
        append("学分", student.getCreditHour()).
        append("平时成绩", student.getRregularScore()).
        append("实验成绩", student.getExperimentalScore()).
        append("卷面成绩", student.getExaminationScore()).
        append("综合成绩", df.format(student.getComprehensiveScore())).
        append("实得学分", df.format(student.getRealcredit()));
        List<Document> documents = new ArrayList<Document>();  
        documents.add(document);  
        collection.insertMany(documents);  
        System.out.println("成绩添加成功"); 
        
        // 生成学生账号
        new GenerateAccount(student.getStuNo());
        
	}
}
