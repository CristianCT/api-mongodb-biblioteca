package com.sofkau.serverside.apimongodbbiblioteca.mappers;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Ejemplar;
import com.sofkau.serverside.apimongodbbiblioteca.models.EjemplarDTO;

public class EjemplarMapper {

    public EjemplarDTO fromEjemplarDTO(Ejemplar ejemplar){
        return new EjemplarDTO(
                ejemplar.getRecursoId(),
                ejemplar.getPrestado(),
                ejemplar.getFechaPrestamo()
        );
    }

    public Ejemplar fromCollection(EjemplarDTO ejemplarDTO){
        Ejemplar ejemplar = new Ejemplar();

        ejemplar.setRecursoId(ejemplarDTO.getIdRecurso());
        ejemplar.setPrestado(ejemplarDTO.getPrestado());
        ejemplar.setFechaPrestamo(ejemplarDTO.getFechaPrestamo());

        return ejemplar;
    }
}
