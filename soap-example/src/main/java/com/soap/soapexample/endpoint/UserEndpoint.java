package com.soap.soapexample.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.soap_example.GetUserRequest;
import com.soap.soap_example.GetUserResponse;
import com.soap.soapexample.service.UserService;

@Endpoint
public class UserEndpoint {

	@Autowired
	private UserService userService;
	
	@PayloadRoot(namespace = "http://soap.com/soap-example",
			localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUserResponse(@RequestPayload GetUserRequest request){
		
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(request.getName()));
		return response;
	}
}
