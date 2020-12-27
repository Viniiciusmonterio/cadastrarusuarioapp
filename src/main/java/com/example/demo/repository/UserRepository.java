package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UsuarioModel;

public interface UserRepository extends CrudRepository<UsuarioModel, Long>{
	UsuarioModel findById(long id);

}