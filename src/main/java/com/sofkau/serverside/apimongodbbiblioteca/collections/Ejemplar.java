package com.sofkau.serverside.apimongodbbiblioteca.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ejemplares")
public class Ejemplar {

    @Id
    private String id;
    private String recursoId;
    private Boolean prestado;
    private LocalDateTime fechaPrestamo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(String recursoId) {
        this.recursoId = recursoId;
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
