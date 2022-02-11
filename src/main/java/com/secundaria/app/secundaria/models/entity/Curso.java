package com.secundaria.app.secundaria.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Column(name = "horas_por_semana")
    private Integer horasSemana;
    @Column(name = "dias_por_semana")
    private Integer diasSemana;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    List<Calificaciones> calificaciones;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Integer getHorasSemana() {
        return this.horasSemana;
    }

    public void setHorasSemana(Integer horasSemana) {
        this.horasSemana = horasSemana;
    }

    public Integer getDiasSemana() {
        return this.diasSemana;
    }

    public void setDiasSemana(Integer diasSemana) {
        this.diasSemana = diasSemana;
    }

    public List<Calificaciones> getCalificaciones() {
        return this.calificaciones;
    }

    public void setCalificaciones(List<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Float aprobados() {
        Float procentaje = 0.0f, promedio;
        for (Calificaciones calificacion : calificaciones) {
            promedio = calificacion.getPromedio();
            if (promedio >= 6) {
                procentaje++;
            }
        }
        return procentaje * 100 / this.calificaciones.size();
    }

    public Float reprobados() {
        Float procentaje = 0.0f, promedio;
        for (Calificaciones calificacion : calificaciones) {
            promedio = calificacion.getPromedio();
            if (promedio < 6) {
                procentaje++;
            }
        }
        return procentaje * 100 / this.calificaciones.size();
    }
}
