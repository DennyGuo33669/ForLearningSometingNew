package com.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GenerateAccount {

	private String idString = "";
	private List idList = new ArrayList<>();
	
	public GenerateAccount(String key) {


		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("mycol");
		MongoCollection<Document> doc = db.getCollection("account");


		List<String> list = new ArrayList<String>();
		list.add(key);
		FindIterable<Document> iter = doc.find().projection(new BasicDBObject().append("ID", 1));
		iter.forEach(new Block<Document>() {
			public void apply(Document _doc) {
				System.out.println(_doc.toJson());
				idString = _doc.getString("ID");
				idList.add(idString);
			}
		});
		

		if(idList.contains(key)!=true) {
			// 选择集合
	        MongoCollection<Document> collection = db.getCollection("account");  
	        // 插入文档  
	        Document document = new Document("ID", key).  
	        append("password", "123").
	        append("description", "学生");
	        List<Document> documents = new ArrayList<Document>();  
	        documents.add(document);  
	        collection.insertMany(documents);  
	        System.out.println("账号"+key+"生成成功"); 
		}else{
			System.out.println("账号"+key +"已存在");
		}		  
       
	}

//	public String getIdString() {
//		return idString;
//	}
//	
//	public void setIdString() {
//		
//	}
//	public List getIdList() {
//		return idList;
//	}
	
	
public static class Test{
		
		public Test(String key) {
			try {
				GenerateAccount generateAccount = new GenerateAccount(key);	
//			System.out.println(generateAccount.getIdString());
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
			
		}
	}
	public static void main(String args[]) {
		new Test("31");
	}
	
}
