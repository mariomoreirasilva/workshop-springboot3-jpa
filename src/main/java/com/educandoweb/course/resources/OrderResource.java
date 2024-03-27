package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//recursos rest da aplicação
@RestController
@RequestMapping("/orders")
public class OrderResource {
	//agora vamos implementar a injeção de pepdendencia
	@Autowired
	private OrderService service;
	
    //o metodo vai responder pelo get do htt anotation abaixo
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		//testar a rquisição web
		//Order u = new Order(1L, "Maria", "maria@gmail.com", "99999999", "123456");
		//return ResponseEntity.ok().body(u);
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	//parâmetro na URL do id
	@GetMapping(value = "/{id}")		//anotarion para o spring saber que esta vindo da url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
