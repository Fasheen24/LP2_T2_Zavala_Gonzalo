package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
    private AreaRepository areaRepository;
	
	
    @GetMapping("/")
    public String home(Model model) {
        List<EmpleadoEntity> listaEmpleado = empleadoRepository.findAll();
        model.addAttribute("lista_empleado", listaEmpleado);
        return "home";
    }

    @GetMapping("/registrar_empleado")
    public String showEmpleadoForm(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        model.addAttribute("lista_areas", areaRepository.findAll());
        return "registrar_empleado";
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute EmpleadoEntity empleado, Model model) {
        try {
            empleadoRepository.save(empleado);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error_message", "Error al intentar registrar el empleado");
            return "registrar_empleado";
        }
        }
    @GetMapping("/actualizar_empleado/{dni}")
    public String showActualizarEmpleadoForm(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadoRepository.findByDni(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            model.addAttribute("lista_areas", areaRepository.findAll());
            return "actualizar_empleado";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/actualizar_empleado/{dni}")
    public String actualizarEmpleado(@PathVariable("dni") String dni,
                                     @ModelAttribute EmpleadoEntity empleadoActualizado,
                                     Model model) {
        EmpleadoEntity empleado = empleadoRepository.findByDni(dni);
        if (empleado != null) {
            empleado.setNomemp(empleadoActualizado.getNomemp());
            empleado.setApeemp(empleadoActualizado.getApeemp());
            empleado.setFechemp(empleadoActualizado.getFechemp());
            empleado.setDirec(empleadoActualizado.getDirec());
            empleado.setCorreo(empleadoActualizado.getCorreo());
            empleadoRepository.save(empleado);
        }
        return "redirect:/";
    }
    @GetMapping("/eliminar_empleado/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni, Model model) {
        empleadoRepository.deleteById(dni);
        return "redirect:/";
    }
    
}
