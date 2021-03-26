package com.cpfValidador.validaCPF.controllers;

import com.cpfValidador.validaCPF.models.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllers {

	@GetMapping("/")
	public String index() {
		return "home/index";
	}

	@GetMapping("/validaCpf")
	public String validaCpf(Cliente cliente, Model model){
		boolean verdade = cliente.validarCPF();
		model.addAttribute("verdade", verdade);
		return "home/cpfValidado";
	}
}
