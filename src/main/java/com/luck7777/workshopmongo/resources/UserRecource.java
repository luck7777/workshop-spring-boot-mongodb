package com.luck7777.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luck7777.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserRecource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User lucas = new User(null, "Lucas Araujo", "ljca84@gmail.com");
		User mateus = new User(null, "Mateus Araujo", "mateus@gmail.com");
		User vanessa = new User(null, "Vanessa Sousa", "vanessa@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(lucas, mateus, vanessa));
		return ResponseEntity.ok().body(list);
	}
}
