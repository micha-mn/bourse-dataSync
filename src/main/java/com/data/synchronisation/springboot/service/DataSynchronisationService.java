package com.data.synchronisation.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class DataSynchronisationService {
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	 @Value("${procedure.debugging.mode}")
		private boolean debuggingMode;

	 
	 @Async
	 public void triggerRobots(String robotName,String columnDescription) throws InterruptedException {
	     System.out.println("excuting Robot for column: "+ robotName +" "+ columnDescription+" time:"+new Date());
	 	try {
	     StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(robotName);
	     query.registerStoredProcedureParameter("columnDescription", String.class, ParameterMode.IN);
		 query.setParameter("columnDescription",columnDescription );
		 query.registerStoredProcedureParameter("debuggingMode", boolean.class, ParameterMode.IN);
		 query.setParameter("debuggingMode",debuggingMode );
		 query.execute();
	     // Artificial delay of 1s for demonstration purposes
	     // Thread.sleep(1000L);
	 	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Async
	 public Future<Boolean> triggerRobot(String robotName,String columnDescription) throws InterruptedException {
	     System.out.println("excuting Robot for column: "+ robotName +" "+ columnDescription+" time:"+new Date());
	     Future<Boolean> value=null;
	     Future<Boolean> futureResult = null;	
	     try {
	    	 futureResult = callAsync(robotName,columnDescription);
	 		
	 		if(futureResult.get())
	 			value = new AsyncResult<Boolean>(true);
	 		
	 	} catch (Exception e) {
			e.printStackTrace();
		}
	     return value;
	 }
	 
	 @Async
	 public Future<Boolean> callAsync(String robotName,String columnDescription) {
		 StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(robotName);
	     query.registerStoredProcedureParameter("columnDescription", String.class, ParameterMode.IN);
		 query.setParameter("columnDescription",columnDescription );
		 query.registerStoredProcedureParameter("debuggingMode", boolean.class, ParameterMode.IN);
		 query.setParameter("debuggingMode",debuggingMode );
		 query.execute();
		 return new AsyncResult<Boolean>(true);
	 }
		
}
