package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.AreaEntitiy;
import com.example.demo.repository.AreaRepository;

@Controller
public class AreaController {
	  @Autowired
	   private AreaRepository areaRepository;
	  
	  @GetMapping("/areas")
	    public String home(Model model) {
	        List<AreaEntitiy> listaAreas = areaRepository.findAll();
	        model.addAttribute("lista_areas", listaAreas);
	        return "home_area";
	    }
	  
	  @GetMapping("/buscar_area")
	    public String buscarArea(@RequestParam("areaid") Integer areaid, Model model) {
	        AreaEntitiy area = areaRepository.findByAreaid(areaid);
	        if (area != null) {
	            model.addAttribute("lista_areas", List.of(area));
	        } else {
	            model.addAttribute("lista_areas", List.of());
	        }
	        return "home_area";
	    }
}
