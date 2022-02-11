package com.secundaria.app.secundaria.models.service;

import java.util.List;

import com.secundaria.app.secundaria.models.dao.CursoDao;
import com.secundaria.app.secundaria.models.entity.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImp implements ICursoService{

    @Autowired
    private CursoDao cursoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Curso> findAll() {
        return (List<Curso>) cursoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Curso findById(Long id) {
        return cursoDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Curso> fetchCursosWithProfesor() {
        return cursoDao.fetchCursosWithProfesor();
    }

    @Transactional(readOnly = true)
    @Override
    public Curso fetchCursoWithProfesorWithCalificacionesWithEstudiante(Long id) {
        return cursoDao.fetchCursoWithProfesorWithCalificacionesWithEstudiante(id);
    }
}
