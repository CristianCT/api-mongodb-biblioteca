package com.sofkau.serverside.apimongodbbiblioteca.models;

import java.time.LocalDateTime;

public class RecursoDTO {

    private String nombre;
    private String tipoRecurso;
    private String areaTematica;

    public RecursoDTO(String nombre, String tipoRecurso, String areaTematica) {
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
        this.areaTematica = areaTematica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }
}
