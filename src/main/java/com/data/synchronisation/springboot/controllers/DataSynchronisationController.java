package com.data.synchronisation.springboot.controllers;



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
    public  ResponseEntity<HttpStatus>  publishNews(@RequestBody RobotInitializerDTO robotInitializerDTO){
		try {
			dataSynchronisationService.triggerRobot(robotInitializerDTO.getRobotName(), robotInitializerDTO.getColumnName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
