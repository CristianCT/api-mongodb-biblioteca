package com.sofkau.serverside.apimongodbbiblioteca.services;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Recurso;
import com.sofkau.serverside.apimongodbbiblioteca.mappers.RecursoMapper;
import com.sofkau.serverside.apimongodbbiblioteca.models.RecursoDTO;
import com.sofkau.serverside.apimongodbbiblioteca.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    RecursoMapper recursoMapper = new RecursoMapper();

    public List<RecursoDTO> filtrarRecursosPorTipo(String tipoRecurso){
        return recursoRepository.findAll()
                .stream()
                .filter(recurso -> recurso.getTipoRecurso().equals(tipoRecurso))
                .map(recurso -> recursoMapper.fromRecursoDTO(recurso))
                .collect(Collectors.toList());
    }

    public List<RecursoDTO> filtrarRecursosPorAreaTematica(String areaTematica){
        return recursoRepository.findAll()
                .stream()
                .filter(recurso -> recurso.getAreaTematica().equals(areaTematica))
                .map(recurso -> recursoMapper.fromRecursoDTO(recurso))
                .collect(Collectors.toList());
    }

    public List<RecursoDTO> filtrarRecursosPorTipoYAreaTematica(String tipoRecurso, String areaTematica){
        return recursoRepository.findAll()
                .stream()
                .filter(recurso -> recurso.getTipoRecurso().equals(tipoRecurso))
                .filter(recurso -> recurso.getAreaTematica().equals(areaTematica))
                .map(recurso -> recursoMapper.fromRecursoDTO(recurso))
                .collect(Collectors.toList());
    }

    public List<RecursoDTO> obtenerRecursos(){
        return recursoRepository.findAll()
                .stream()
                .map(recurso -> recursoMapper.fromRecursoDTO(recurso))
                .collect(Collectors.toList());
    }

    public String eliminarRecurso(String recursoId){
        Optional<Recurso> recurso = recursoRepository.findById(recursoId);

        if (recurso != null){
            recursoRepository.deleteById(recursoId);
            return "Recurso Eliminado";
        }
        return "El recurso no existe";
    }

    public RecursoDTO actualizarRecurso(String recursoId, RecursoDTO recursoDTO){
        Recurso recurso = recursoRepository.findById(recursoId).orElseThrow();

        recurso.setTipoRecurso(recursoDTO.getTipoRecurso()!=null?recursoDTO.getTipoRecurso():recurso.getTipoRecurso());
        recurso.setAreaTematica(recursoDTO.getAreaTematica()!=null?recursoDTO.getAreaTematica():recurso.getAreaTematica());
        recurso.setNombre(recursoDTO.getNombre()!=null?recursoDTO.getNombre():recurso.getNombre());

        return recursoMapper.fromRecursoDTO(recursoRepository.save(recurso));
    }

    public RecursoDTO crearRecurso(RecursoDTO recursoDTO){
        Recurso recurso = recursoMapper.fromCollection(recursoDTO);
        return recursoMapper.fromRecursoDTO(recursoRepository.save(recurso));
    }
}
