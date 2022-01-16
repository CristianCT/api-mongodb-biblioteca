package com.sofkau.serverside.apimongodbbiblioteca.mappers;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Recurso;
import com.sofkau.serverside.apimongodbbiblioteca.models.RecursoDTO;

public class RecursoMapper {
    public RecursoDTO fromRecursoDTO(Recurso recurso){
        return new RecursoDTO(
                recurso.getNombre(),
                recurso.getTipoRecurso(),
                recurso.getAreaTematica()
        );
    }

    public Recurso fromCollection(RecursoDTO recursoDTO){
        Recurso recurso = new Recurso();
        recurso.setTipoRecurso(recursoDTO.getTipoRecurso());
        recurso.setNombre(recursoDTO.getNombre());
        recurso.setAreaTematica(recursoDTO.getAreaTematica());

        return recurso;
    }
}
