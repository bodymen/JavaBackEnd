package com.curso.m13.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.m13.dto.*;
import com.curso.m13.service.impl.IEmpleadoService;

@Controller
@RequestMapping("")
public class EmpleadoController {

	// Contador Mock, hay 3 en el Array.
	private int contadorId = 3;

	@Autowired
	private final IEmpleadoService empleadoService;

	private EmpleadoDto empleado;

	public EmpleadoController(IEmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	@GetMapping("/empleado")
	public String listEmpleados(Model model) {
		List<EmpleadoDto> empleados = empleadoService.findAll();

		model.addAttribute("empleados", empleados);
		return "listEmpleados";
	}

	@GetMapping("/empleado/{empleadoid}")
	private String getEmpleado(@PathVariable("empleadoid") int empleadoid) {
		empleadoService.findAllById(empleadoid);

		return "redirect:/empleado";
	}

	@GetMapping("/buscar")
	@ResponseBody
	public ModelAndView buscar(@RequestParam(name = "puesto", required = false, defaultValue = "null") String puesto,
			ModelAndView model) {
		List<EmpleadoDto> empleados;
		if (puesto == null)
			empleados = empleadoService.findAll();
		else {
			empleados = (List<EmpleadoDto>) empleadoService.findAll().stream()
					.filter(s -> s.getPuesto().contains(puesto)).collect(Collectors.toList());
		}
		model.addObject("empleados", empleados);
		model.setViewName("listEmpleados");
		return model;
	}

	@DeleteMapping("/empleado/{empleadoid}")
	private String deleteEmpleado(@PathVariable("empleadoid") int empleadoid, RedirectAttributes redirectAttrs) {
		empleadoService.deletebyId(empleadoid);
		redirectAttrs.addFlashAttribute("mensaje", "Borrado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/empleado";
	}

	@PostMapping(value = "/empleado", consumes = { MediaType.ALL_VALUE })
	private String insertar(EmpleadoDto empleado, RedirectAttributes redirectAttrs) {
		contadorId++;
		empleado.setId(contadorId);
		empleado.setSalari(FeinesEnum.valueOf(empleado.getPuesto()).getNumVal());
		empleadoService.saveOrUpdate(empleado);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/empleado";
	}

	@PutMapping(value = "/empleado", consumes = { MediaType.ALL_VALUE })
	private String update(EmpleadoDto empleado, Model model, RedirectAttributes redirectAttrs) {
		empleado.setSalari(FeinesEnum.valueOf(empleado.getPuesto()).getNumVal());
		empleadoService.saveOrUpdate(empleado);
		redirectAttrs.addFlashAttribute("mensaje", "Actualizado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/empleado";
	}

	@GetMapping(value = "/edit/{empleadoid}")
//	@ResponseBody				//@ModelAttribute
	public String update(@PathVariable("empleadoid") int empleadoid, Model model) {
		empleado = empleadoService.findAllById(empleadoid);
		model.addAttribute("empleado", empleado);
		return "empleado";
	}

}
