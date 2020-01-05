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

		//����С����1λ
		DecimalFormat df = new DecimalFormat("#.0"); 
		
		df.format(student.getRealcredit());
		// ���ӵ� mongodb ����
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        
        // ���ӵ����ݿ�
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
        System.out.println("Connect to database successfully");
        
        // ѡ�񼯺�
        MongoCollection<Document> collection = mongoDatabase.getCollection("score");
        System.out.println("���� score ѡ��ɹ�");
        
        // �����ĵ�  
        Document document = new Document("ѧ��", student.getStuNo()).  
        append("�γ̱��", student.getClassNo()).  
        append("�γ�����", student.getClassName()).
        append("ѧ��", student.getCreditHour()).
        append("ƽʱ�ɼ�", student.getRregularScore()).
        append("ʵ��ɼ�", student.getExperimentalScore()).
        append("����ɼ�", student.getExaminationScore()).
        append("�ۺϳɼ�", df.format(student.getComprehensiveScore())).
        append("ʵ��ѧ��", df.format(student.getRealcredit()));
        List<Document> documents = new ArrayList<Document>();  
        documents.add(document);  
        collection.insertMany(documents);  
        System.out.println("�ɼ���ӳɹ�"); 
        
        // ����ѧ���˺�
        new GenerateAccount(student.getStuNo());
        
	}
}
