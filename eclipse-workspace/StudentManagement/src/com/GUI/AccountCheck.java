package com.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AccountCheck {

	private String idString = "";
	private String pwdString = "";
	private String descriptionString ="";

	public AccountCheck(String key) {
		
		// 连接数据库
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("mycol");
		MongoCollection<Document> doc = db.getCollection("account");

		//获取数据库内账号&密码
				List<String> list = new ArrayList<String>();
				list.add(key);
				FindIterable<Document> iter = doc.find(new Document("ID", new Document("$in", list)));
				iter.forEach(new Block<Document>() {
					public void apply(Document _doc) {
						System.out.println(_doc.toJson());
						idString = _doc.getString("ID");
						pwdString = _doc.getString("password");
						descriptionString =_doc.getString("description");
					}
				});
	}
	
	public String getIdString() {
		return idString;
	}
	public String getpwdString() {
		return pwdString;
	}

	public String getDescriptionString() {
		return descriptionString;
	}
	// 测试类
	public static class Test{
		
		public Test(String key) {
			try {
				AccountCheck accountCheck = new AccountCheck(key);
				System.out.println("账号"+accountCheck.getIdString());
				System.out.println("密码"+accountCheck.getpwdString());	
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
			
		}
	}
	public static void main(String args[]) {
		new Test("09");
	}
}


