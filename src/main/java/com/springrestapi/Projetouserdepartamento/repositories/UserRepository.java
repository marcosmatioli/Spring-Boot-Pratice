package com.springrestapi.Projetouserdepartamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.Projetouserdepartamento.entities.User;

/*
 * objeto especifico para acessar um dado no banco de dados
 * utilizamos o nome do objeto + Repository
 * 
 * então fazemos uma interface que extends a Jpa informamos qual a classe o tipo de ID, normalmente Long
 * 
 * importante que aqui vamos criar os endpoints da api rest ou seja vamos fazer todas as ações do usuario 
 * aqui, deletar, salvar, atualizar entre outros como uma api.
 * 
 * vamos usar um controlador REST
 * */
public interface UserRepository extends JpaRepository<User, Long> {

}
