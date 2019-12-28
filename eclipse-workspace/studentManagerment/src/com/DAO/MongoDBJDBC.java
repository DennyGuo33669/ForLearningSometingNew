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
		// 连接到 mongodb 服务
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
      
		// 连接到数据库
		MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
		System.out.println("Connect to database successfully/数据库连接成功");

		// 创建集合
		mongoDatabase.createCollection(collectionName);
		System.out.println("集合创建成功");
	}
	
	
	public void getCollection(String databaseName,String collectionName) {
		// 连接到 mongodb 服务
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		      
				// 连接到数据库
				MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
				System.out.println("Connect to database successfully/数据库连接成功");
		MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
	       System.out.println("集合   "+collectionName+"  选择成功");
	}
	
	
	public void insert(String databaseName,String collectionName) {
		// 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
        System.out.println("Connect to database successfully");
        
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        System.out.println("集合   "+collectionName+"  选择成功");
        //插入文档  
        /** 
        * 1. 创建文档 org.bson.Document 参数为key-value的格式 
        * 2. 创建文档集合List<Document> 
        * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
        * */
        Document document = new Document("account", "admin").  
        append("password", "123456").
        append("description", "admin");  
        List<Document> documents = new ArrayList<Document>();  
        documents.add(document);  
        collection.insertMany(documents);  
        System.out.println("文档插入成功"); 
	}
	
	public void show(String databaseName,String collectionName) {
		
		String string ="";
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	        
	        // 连接到数据库
	        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);  
	        System.out.println("Connect to database successfully");
	        
	        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
	        System.out.println("集合   "+collectionName+"  选择成功");
	        
	        //检索所有文档  
	         /** 
	         * 1. 获取迭代器FindIterable<Document> 
	         * 2. 获取游标MongoCursor<Document> 
	         * 3. 通过游标遍历检索出的文档集合 
	         * */  
	         FindIterable<Document> findIterable = collection.find();  
	         MongoCursor<Document> mongoCursor = findIterable.iterator();  
	         while(mongoCursor.hasNext()){  
	        	 
	        	 
	        	 Document accountDocument = mongoCursor.next();
	        	 String idString = accountDocument.getString("ID");
	        	 String pwString = accountDocument.getString("password");
	        	 
	        	 
	             System.out.println("账户"+ idString +"密码:"+pwString );
	                
	                
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

