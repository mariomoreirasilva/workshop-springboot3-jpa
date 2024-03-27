package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//anotation para falar que é exclusivo para o perfil de teste

@Configuration
@Profile("test")
//instanciar objetos quando o programa foi iniciado implement CommandLineRunner
public class TestConfig implements CommandLineRunner {
	//injeção de dependencia. O proprio spring resolve com o anotarion abaixo. Não precisa de contrutor, padrao factory, por exemplo
	
	@Autowired
	private UserRepository userRepositry;

	@Override
	public void run(String... args) throws Exception {
		//METODO RUN é executado quando a aplicação roda.
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepositry.saveAll(Arrays.asList(u1,u2));
		
	}
	

}
