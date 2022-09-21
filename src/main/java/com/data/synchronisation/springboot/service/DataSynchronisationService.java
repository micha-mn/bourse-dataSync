package com.data.synchronisation.springboot.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class DataSynchronisationService {
	 @PersistenceContext
	 private EntityManager entityManager;
	 
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
		
}
