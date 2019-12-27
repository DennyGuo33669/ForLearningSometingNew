package com.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AccountCheck{

	
	public static String idString = "";
	public static String pwString = "";
	
	public AccountCheck(String key) {
		MongoClient mongoClient = new MongoClient();

    	MongoDatabase db = mongoClient.getDatabase("mycol");
    	MongoCollection<Document> doc = db.getCollection("account");
    	
    	
    	List<String> list = new ArrayList<String>();
    	list.add(key);
    	FindIterable<Document> iter = doc.find(new Document("ID",new Document("$in",list)));
    	iter.forEach(new Block<Document>() {
    	public void apply(Document _doc) {
//    	System.out.println(_doc.toJson());
    	AccountCheck.idString=_doc.getString("ID");
    	AccountCheck.pwString=_doc.getString("password");
    	}
    	});
    	
	}

	
public static void main( String args[] ){

    try{
       
    	
    	

    }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
}
}