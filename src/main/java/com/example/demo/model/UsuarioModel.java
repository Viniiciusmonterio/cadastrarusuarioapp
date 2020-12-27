package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.controller.UsuarioController;
import com.sun.istack.NotNull;


@Entity
@Table(name="tb_usuario")
public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )	
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	@NotNull
	private String data;	
	private String senha;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		
		this.senha = senha;
	}

	public void addAttribute(String string, List<UsuarioController> lista) {
		// TODO Auto-generated method stub
		
	}
	
}
