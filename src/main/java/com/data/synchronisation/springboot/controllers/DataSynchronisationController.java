package com.data.synchronisation.springboot.controllers;



import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.synchronisation.springboot.dto.RobotInitializerDTO;
import com.data.synchronisation.springboot.service.DataSynchronisationService;
@RestController
@RequestMapping(value = "databseSynchro")
public class DataSynchronisationController {

	@Autowired
	private final DataSynchronisationService dataSynchronisationService;
	
	public DataSynchronisationController(DataSynchronisationService dataSynchronisationService)
	{
		this.dataSynchronisationService = dataSynchronisationService;
	}
	
	@PostMapping(value = "runrobot", produces = "application/json;charset=UTF-8")
    public  ResponseEntity<Boolean>  publishNews(@RequestBody RobotInitializerDTO robotInitializerDTO) throws InterruptedException, ExecutionException{
		Future<Boolean> value=null;
		try {
			 value= dataSynchronisationService.triggerRobot(robotInitializerDTO.getRobotName(), robotInitializerDTO.getColumnName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(value.get(), HttpStatus.CREATED);
    }
	
	@PostMapping(value = "runrobots", produces = "application/json;charset=UTF-8")
    public ResponseEntity<HttpStatus> publishNewss(@RequestBody RobotInitializerDTO robotInitializerDTO) throws InterruptedException, ExecutionException{
	
		try {
			dataSynchronisationService.triggerRobots(robotInitializerDTO.getRobotName(), robotInitializerDTO.getColumnName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<>(HttpStatus.OK);

    }
	
}
