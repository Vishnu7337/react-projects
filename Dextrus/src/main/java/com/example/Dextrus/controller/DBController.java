package com.example.Dextrus.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dextrus.entity.SQLConnectionPropertiesFiles;

@RestController
@RequestMapping
public class DBController {
	
	@GetMapping("/get")
	public ResponseEntity<String> testConnection(@RequestBody SQLConnectionPropertiesFiles properties) {
		try {
			Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con=DriverManager.getConnection(properties.getUrl(),properties.getUsername(),properties.getPassword());
			
			 return ResponseEntity.ok("{\"status\":\"success\"}");
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"error\",\"message\":\""+e.getMessage()+"\"}");
		     
			
		}
		
	}

	@GetMapping("/")
	public ResponseEntity<Void>  getSchema(){
		
	}
	
}
