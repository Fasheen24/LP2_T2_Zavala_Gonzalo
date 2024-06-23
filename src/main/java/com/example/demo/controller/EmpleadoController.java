package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		List<EmpleadoEntity> listaEmpleado = empleadoRepository.findAll();
		model.addAttribute("lista_empleado",listaEmpleado );
		return "home";
	}
	@GetMapping("/registrar_empleado")
	public String showEmpleado(Model model) {
		model.addAttribute("dni", new EmpleadoEntity());
		return "registrar_empleado";
	}
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute EmpleadoEntity empleado, Model model) {
		empleadoRepository.save(empleado);
		return "redirect:/";
	}
}
