package com.secundaria.app.secundaria.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calificacion_1")
    private Float calificacion1;
    @Column(name = "calificacion_2")
    private Float calificacion2;
    @Column(name = "calificacion_3")
    private Float calificacion3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(Float calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public Float getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(Float calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public Float getCalificacion3() {
        return calificacion3;
    }

    public void setCalificacion3(Float calificacion3) {
        this.calificacion3 = calificacion3;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public float getPromedio() {
        return (calificacion1 + calificacion2 + calificacion3) / 3;
    }

}
