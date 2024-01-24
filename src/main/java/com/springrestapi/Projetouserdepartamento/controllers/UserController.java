package com.springrestapi.Projetouserdepartamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.Projetouserdepartamento.entities.User;
import com.springrestapi.Projetouserdepartamento.repositories.UserRepository;


/*
 * só colocar RestController que ele já ira responder por requisições
 * */
@RestController
@RequestMapping(value = "/users")
/*
 * aqui vc pode dizer o mapping global, ou seja qual a raiz da coisa e os metodos abaixo
 * já corresponde a esse patch
 * */
public class UserController {

	/*
	 * vamos fazer uma injeção de dependencia para ele já ser instanciado
	 * esse @Autowired
	 * */
	@Autowired
	private UserRepository repository;
	
	/*
	 * get mapping então é get
	 * já volta um json com esse metodo
	 * 
	 * */
	@GetMapping
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	/*
	 * utilizamos o @pathvariable para indicar que o long id é referente ao patch que vamos 
	 * passar, então é basicamente igual ao python
	 * preciso enteder como funciona todos os comandos do respositoty para entender o que é possivel
	 * e o que não é
	 * */
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	/*
	 * não preciso do patch aqui porque quando a requisição for do tipo Post ele ja vai saber que é post
	 * o save já salva o objeto no banco de dados
	*/
	@PostMapping 
	public User insert(@RequestBody User user){
		User result = repository.save(user);
		return result;
	}
}
