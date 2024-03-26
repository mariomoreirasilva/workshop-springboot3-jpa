package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//recursos rest da aplicação
@RestController
@RequestMapping("/users")
public class UserResource {
    //o metodo vai responder pelo get do htt anotation abaixo
	@GetMapping
	public ResponseEntity<User> findAll(){
		//testar a rquisição web
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}
