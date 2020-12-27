package com.example.demo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UserRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping(value ="/salvar", method = RequestMethod.GET)
	public String formSalvar() {
		return "/salvar";
	}
	
	@RequestMapping(value ="/salvar", method = RequestMethod.POST)
	public String salvar(UsuarioModel user) {
		String dataCadas = user.getData();
		String cpf = user.getCpf();
		user.setSenha(cpf.substring(0,3) + dataCadas.substring(5,7)); 
		repository.save(user); 
		return "redirect:/listar";
		
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView formListar() {
		ModelAndView mv =new ModelAndView("index");
		Iterable<UsuarioModel> user = repository.findAll(); 
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView detalhesUsuario(@PathVariable("id") long id) {
		UsuarioModel user = repository.findById(id);
		ModelAndView mv = new ModelAndView("detalhes");
		mv.addObject("user", user);
		repository.save(user);
		return mv;
		
	}
	
	@RequestMapping("/deletar")
	public String deleteUsuario(long id, RedirectAttributes attributes) {
		UsuarioModel user = repository.findById(id);
		repository.delete(user);
		attributes.addFlashAttribute("mensagem", "Usuario deletado");
		return "redirect:/listar";
	}
	
		
}