package com.secundaria.app.secundaria.controllers;

import com.secundaria.app.secundaria.models.entity.Curso;
import com.secundaria.app.secundaria.models.service.ICursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        model.addAttribute("titulo", "Lista de cursos");
        model.addAttribute("cursos", cursoService.fetchCursosWithProfesor());
        return "cursos/index";
    }

    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable Long id,Model model,RedirectAttributes flash) {
        Curso curso= cursoService.fetchCursoWithProfesorWithCalificacionesWithEstudiante(id);
        if(curso.equals(null)){
            flash.addFlashAttribute("error","El curso con ID: "+id+" no existe en la base de datos!!");
            return "currsos/index";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Detalles del curso "+curso.getNombre());
        return "cursos/ver";
    }

}
