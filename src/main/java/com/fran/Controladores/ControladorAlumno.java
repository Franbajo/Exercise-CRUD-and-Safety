package com.fran.Controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fran.Entidad.Alumno;
import com.fran.Entidad.Clientes;
import com.fran.Servicio.IAlumnoService;

@Controller
public class ControladorAlumno {
	
	@Autowired
	private IAlumnoService service;
	
/*................LISTAR...................*/
	@GetMapping("/listarAlumno")
	public String listar(Model model) {
		List<Alumno>personas=service.listar();
		model.addAttribute("alumno", personas);
		return"alumno/index";
}
/*................CREAR Y GUARDAR...................*/
	@GetMapping("/newAlumno")
	public String agregar(Model model) {
		model.addAttribute("alumno", new Alumno());
		return"alumno/form";
	}
	@PostMapping("/saveAlumno")
	public String save(@Valid @ModelAttribute("alumno")  Alumno p, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
					
		System.out.println("Error al introducir los datos"+result.getAllErrors());
				model.addAttribute("alumno", p);
					
				return"alumno/form"; 
			}
				service.save(p);
				attribute.addFlashAttribute("success", "Alumno guardado con exito!");
				return"redirect:/listarAlumno";
		}

	/*...................EDITAR.......................*/	
	@GetMapping("/editarAlumno/{id}")
	public String editar(@PathVariable long id, Model model, RedirectAttributes attribute) {
	Optional<Alumno>persona=service.listarId(id);
	model.addAttribute("alumno", persona);
	attribute.addFlashAttribute("success", "Datos del alumno actualizados!");
	return"alumno/form";
}
/*...................BORRAR.......................*/		
	@GetMapping("/eliminarAlumno/{id}")
	public String delete(Model model, @PathVariable long id, RedirectAttributes attribute) {
			service.delete(id);
			attribute.addFlashAttribute("error", "ATENCIÓN: registro eliminado!");
			return"redirect:/listarAlumno";
	}
}
