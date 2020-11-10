package com.luck7777.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luck7777.workshopmongo.domain.User;
import com.luck7777.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserRecource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
}
