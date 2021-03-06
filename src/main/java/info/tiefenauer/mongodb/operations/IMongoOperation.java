package info.tiefenauer.mongodb.operations;

import org.bson.Document;

import info.tiefenauer.mongodb.Log;

public interface IMongoOperation {

	void execute();
	
	default void log(Object obj){
		Log.log(getClass(), obj);
	}
	
	default void logResultCount(Iterable<Document> iterable){
		int size = 0;
		for (Document document : iterable) {
			size++;
		}
		Log.logSize(this, getMongoOperationNamePast(), size);
	}
	
	default void logResultCount(long size){
		Log.logSize(this, getMongoOperationNamePast(), size);
	}

	String getMongoOperationName();
	String getMongoOperationNamePast();
	
	
}
