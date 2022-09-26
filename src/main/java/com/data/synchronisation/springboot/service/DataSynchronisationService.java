package com.data.synchronisation.springboot.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

@Service
public class DataSynchronisationService {
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	 @Value("${procedure.debugging.mode}")
		private boolean debuggingMode;

	 /*
	 @Async
	 public void triggerRobot(String robotName,String columnDescription) throws InterruptedException {
	     System.out.println("excuting Robot for column: "+ robotName +" "+ columnDescription+" time:"+new Date());
	 	try {
	     StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(robotName);
	     query.registerStoredProcedureParameter("columnDescription", String.class, ParameterMode.IN);
		 query.setParameter("columnDescription",columnDescription );
		 query.execute();
	     // Artificial delay of 1s for demonstration purposes
	     // Thread.sleep(1000L);
	 	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 */
	 @Async
	 public void triggerRobot(String robotName,String columnDescription) throws InterruptedException {
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
		
}
