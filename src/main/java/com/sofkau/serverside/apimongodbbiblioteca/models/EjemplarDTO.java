package com.sofkau.serverside.apimongodbbiblioteca.models;

import java.time.LocalDateTime;

public class EjemplarDTO {

    private String idRecurso;
    private Boolean prestado;
    private LocalDateTime fechaPrestamo;

    public EjemplarDTO(String idRecurso, Boolean prestado, LocalDateTime fechaPrestamo) {
        this.idRecurso = idRecurso;
        this.prestado = prestado;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
