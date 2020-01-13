package com.DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.ValueCodecProvider;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class MongoDBJDBC{
	
	public void conn(String databaseName,String collectionName) {
		// ���ӵ� mongodb ����
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
      
		// ���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
		System.out.println("Connect to database successfully/���ݿ����ӳɹ�");

		// ��������
		mongoDatabase.createCollection(collectionName);
		System.out.println("���ϴ����ɹ�");
	}
	
	
	public void getCollection(String databaseName,String collectionName) {
		// ���ӵ� mongodb ����
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		      
				// ���ӵ����ݿ�
				MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
				System.out.println("Connect to database successfully/���ݿ����ӳɹ�");
		MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
	       System.out.println("����   "+collectionName+"  ѡ��ɹ�");
	}
	
	
	public void insert(String databaseName,String collectionName) {
		// ���ӵ� mongodb ����
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        
        // ���ӵ����ݿ�
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
        System.out.println("Connect to database successfully");
        
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        System.out.println("����   "+collectionName+"  ѡ��ɹ�");
        //�����ĵ�  
        /** 
        * 1. �����ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ 
        * 2. �����ĵ�����List<Document> 
        * 3. ���ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>) ���뵥���ĵ������� mongoCollection.insertOne(Document) 
        * */
        Document document = new Document("account", "admin").  
        append("password", "123456").
        append("description", "admin");  
        List<Document> documents = new ArrayList<Document>();  
        documents.add(document);  
        collection.insertMany(documents);  
        System.out.println("�ĵ�����ɹ�"); 
	}
	
	public void show(String databaseName,String collectionName) {
		
		String string ="";
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	        
	        // ���ӵ����ݿ�
	        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
	        System.out.println("Connect to database successfully");
	        
	        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
	        System.out.println("����   "+collectionName+"  ѡ��ɹ�");
	        
	        //���������ĵ�  
	         /** 
	         * 1. ��ȡ������FindIterable<Document> 
	         * 2. ��ȡ�α�MongoCursor<Document> 
	         * 3. ͨ���α�������������ĵ����� 
	         * */  
	         FindIterable<Document> findIterable = collection.find();  
	         MongoCursor<Document> mongoCursor = findIterable.iterator();  
	         while(mongoCursor.hasNext()){  
	        	 
	        	 
	        	 Document accountDocument = mongoCursor.next();
	        	 String idString = accountDocument.getString("ID");
	        	 String pwString = accountDocument.getString("password");
	        	 
	        	 
	             System.out.println("�˻�"+ idString +"����:"+pwString );
	                
	                
//	            System.out.println(mongoCursor.next()); 
	         }  
	}
	
    public static void main( String args[] ){

        try{
        	MongoDBJDBC db = new MongoDBJDBC();
//        	db.conn("mycol","account");
//        	db.getCollection("mycol", "account");
//        	db.insert("mycol", "account");
        	db.show("mycol", "account");
        	
        	
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
