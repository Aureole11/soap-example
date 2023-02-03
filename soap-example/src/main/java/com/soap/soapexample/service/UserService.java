package com.soap.soapexample.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.soap.soap_example.User;

@Service
public class UserService {

	private static final Map<String, User> users = new HashMap<>();
	
	@PostConstruct
	public void initialize() {
		
		User peter = new User();
		peter.setName("Peter");
		peter.setEmpId(1);
		peter.setSalary(10000);
		
		User sam = new User();
		sam.setName("Sam");
		sam.setEmpId(2);
		sam.setSalary(12000);
		
		User ryan = new User();
		ryan.setName("Ryan");
		ryan.setEmpId(3);
		ryan.setSalary(14000);
		
		users.put(peter.getName(), peter);
		users.put(sam.getName(), sam);
		users.put(ryan.getName(), ryan);
	}
	
	public User getUsers(String name) {
		return users.get(name);
	}
}
