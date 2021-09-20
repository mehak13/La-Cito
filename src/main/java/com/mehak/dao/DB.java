package com.mehak.dao;

import java.util.ArrayList;

import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.types.ObjectId;


import com.mehak.model.Patient;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;


public class DB {

	MongoClient mongoClient;

	public DB() {
		try {
			String connectionURL = "mongodb+srv://root:mehak.123@cluster0.eixaz.mongodb.net/sqlConnection?retryWrites=true&w=majority";
	    	mongoClient = MongoClients.create(connectionURL);
	    	
	    	
		} catch (Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}
}
	
public boolean registerUser(Patient patient) {
		
		Document document = new Document(patient.toMap());
    	
    	//Insert into DataBase
		try {
    	mongoClient.getDatabase("sqlConnection").getCollection("Patients").insertOne(document);
    	System.out.println(patient.getName()+" Regsitered in MongoDB :)");
		return true;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
    	
    /*	boolean flag = cursor.hasNext();
    	if(flag) {
    		//System.out.println(cursor.next().toJson());
    		Document document = cursor.next();
    		System.out.println(document.getObjectId("_id"));
    		System.out.println(document.getString("name"));
    		
    		patient._id = document.getObjectId("_id").toString();
    		patient.name = document.getString("name");
    		
    		System.out.println("[DB] User Data After Successful Login:"+patient);
    		
    	}
		
		return flag;*/
	}

public void deletePatient(String patientId) {
	
	System.out.println("[DB] Deleting Fever:"+patientId);
	
	BasicDBObject query = new BasicDBObject();

	query.put("_id", new ObjectId(patientId));
	
	// Fetching the Data
	mongoClient.getDatabase("sqlConnection").getCollection("Patients").deleteOne(query);
	
}

public void updatePatient(String name, String patientId) {
	
	BasicDBObject query = new BasicDBObject();
	query.put("_id", new ObjectId(patientId));
	
	try {
		MongoCursor<Document> cursor = mongoClient.getDatabase("sqlConnection").getCollection("Patients").find().iterator();
    	while(cursor.hasNext()) {
    		Document document = cursor.next();
    		if (document.getObjectId("_id").toString().equals(patientId)) {
    			document.put("txtName", name);
    			mongoClient.getDatabase("sqlConnection").getCollection("Patients").updateOne(query, document);
    			System.out.println("Patient Updated");
    		}
    	}
	}catch(Exception e) {
		System.out.println("Something Went Wrong: "+e);
	}

}


public void fetchUsers() {
	
	try {
		MongoCursor<Document> cursor = mongoClient.getDatabase("sqlConnection").getCollection("Patients").find().iterator();
    	while(cursor.hasNext()) {
    		//System.out.println(cursor.next());
    		System.out.println(cursor.next().toJson());
    	}
	}catch(Exception e) {
		System.out.println("Something Went Wrong: "+e);
	}
	
}

public ArrayList<Patient> fetchPatients() {
	
	ArrayList<Patient> patientRecords = new ArrayList<Patient>();
	
	try {
		
		//BasicDBObject query = new BasicDBObject();
		//query.put("_id", new ObjectId(patientId));
		
    	MongoCursor<Document> cursor = mongoClient.getDatabase("sqlConnection").getCollection("Patients").find().iterator();
    	while(cursor.hasNext()) {
    		
    		Document document = cursor.next();
    		Patient patient = new Patient();
    		patient._id = document.getObjectId("_id").toString();
    		patient.name = document.getString("name").toString();
    		patient.phone = document.getString("phone").toString();
    		patient.timings = document.getString("timings").toString();
    		
    		patientRecords.add(patient);
    		
    	}
	}catch(Exception e) {
		System.out.println("Something Went Wrong: "+e);
	}
	
	return patientRecords;
	
}
}
