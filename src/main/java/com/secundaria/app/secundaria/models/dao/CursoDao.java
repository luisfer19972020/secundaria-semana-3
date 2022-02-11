package com.secundaria.app.secundaria.models.dao;

import java.util.List;

import com.secundaria.app.secundaria.models.entity.Curso;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CursoDao extends CrudRepository<Curso, Long> {
    @Query("select c from Curso c join fetch c.profesor p")
    public List<Curso> fetchCursosWithProfesor();

    @Query("select c from Curso c join fetch c.profesor p left join fetch c.calificaciones k left join fetch k.estudiante e where c.id=?1")
    public Curso fetchCursoWithProfesorWithCalificacionesWithEstudiante(Long id);
}
