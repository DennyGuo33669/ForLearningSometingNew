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

	public AccountCheck(String key) {
		// �������ݿ�
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("mycol");
		MongoCollection<Document> doc = db.getCollection("account");

		List<String> list = new ArrayList<String>();
		list.add(key);
		FindIterable<Document> iter = doc.find(new Document("ID", new Document("$in", list)));
		iter.forEach(new Block<Document>() {
			public void apply(Document _doc) {
//				System.out.println(_doc.toJson());
				idString = _doc.getString("ID");
				pwdString = _doc.getString("password");
			}
		});
	}
	
	public String getIdString() {
		return idString;
	}
	public String getpwdString() {
		return pwdString;
	}

	public static void main(String args[]) {

		try {

			AccountCheck accountCheck = new AccountCheck("admin");
			System.out.println("�˺�"+accountCheck.getIdString());
			System.out.println("����"+accountCheck.getpwdString());
			
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}