package com.springrestapi.Projetouserdepartamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*mapeamento é feito com anotation*/
@Entity
@Table(name = "tb_user")
public class User {

	/*
	 * com isso eu to falando que ele é uma chace primaria então ele está
	 * instanciando mas ainda não tem um relacionamento para chave estrangeira
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	/*
	 * quando eu coloco que essa entidade precisa ter um department ela basicamente
	 * tem que exister antes de criar um user, então isso faz com que precisa
	 * existir pelo um departamento para criar um usuario que também vai compor as
	 * caracteristicas desse usuario
	 */
	/*
	 * relacionamento entre tabelas, ManyToOne - OneToOne - ManyToMany - OneToMany
	 */
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
