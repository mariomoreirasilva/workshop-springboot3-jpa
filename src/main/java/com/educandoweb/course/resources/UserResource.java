package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//recursos rest da aplicação
@RestController
@RequestMapping("/users")
public class UserResource {
	//agora vamos implementar a injeção de pepdendencia
	@Autowired
	private UserService service;
	
    //o metodo vai responder pelo get do htt anotation abaixo
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//testar a rquisição web
		//User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	//parâmetro na URL do id
	@GetMapping(value = "/{id}")		//anotarion para o spring saber que esta vindo da url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
