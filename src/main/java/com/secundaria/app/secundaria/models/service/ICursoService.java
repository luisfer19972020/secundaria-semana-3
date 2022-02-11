package com.secundaria.app.secundaria.models.service;

import java.util.List;

import com.secundaria.app.secundaria.models.entity.Curso;

public interface ICursoService {
    public List<Curso> findAll();

    public List<Curso> fetchCursosWithProfesor();

    public Curso findById(Long id);

    public Curso fetchCursoWithProfesorWithCalificacionesWithEstudiante(Long id);
}
