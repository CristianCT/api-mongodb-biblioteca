package com.sofkau.serverside.apimongodbbiblioteca.services;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Ejemplar;
import com.sofkau.serverside.apimongodbbiblioteca.mappers.EjemplarMapper;
import com.sofkau.serverside.apimongodbbiblioteca.mappers.RecursoMapper;
import com.sofkau.serverside.apimongodbbiblioteca.models.EjemplarDTO;
import com.sofkau.serverside.apimongodbbiblioteca.repositories.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository ejemplaresRepository;

    EjemplarMapper ejemplarMapper = new EjemplarMapper();

    public String consultarDisponibilidad(String recursoId){
        List<Ejemplar> ejemplares = ejemplaresRepository.findByRecursoIdAndPrestado(recursoId, false);
        if (ejemplares.size() == 0) {
            return "El recurso no se encuentra disponible\nUltimo prestamo: " +
                    ejemplaresRepository.findByRecursoIdAndPrestado(recursoId, true)
                        .stream()
                        .sorted((ejemplarA, ejemplarB) -> ejemplarB.getFechaPrestamo().compareTo(ejemplarA.getFechaPrestamo()))
                        .collect(Collectors.toList())
                        .get(0)
                        .getFechaPrestamo()
                        .toString();
        }
        return "El recurso se encuentra disponible";
    }

    public String prestarRecurso(String recursoId){
        List<Ejemplar> ejemplares = ejemplaresRepository.findByRecursoIdAndPrestado(recursoId, false);
        if (ejemplares.size() == 0) {
            return "El recurso no se encuentra disponible";
        }
        ejemplares.get(0).setPrestado(true);
        ejemplares.get(0).setFechaPrestamo(LocalDateTime.now());
        ejemplaresRepository.save(ejemplares.get(0));
        return "Un ejemplar del recurso " + ejemplares.get(0).getRecursoId() + " ha sido prestado con exito";
    }
    public String devolverRecurso(String recursoId){
        List<Ejemplar> ejemplares = ejemplaresRepository.findByRecursoIdAndPrestado(recursoId, true);
        if (ejemplares.size() == 0) {
            return "El recurso no se encuentra prestado";
        }
        ejemplares.get(0).setPrestado(false);
        ejemplares.get(0).setFechaPrestamo(null);
        ejemplaresRepository.save(ejemplares.get(0));
        return "Un ejemplar del recurso " + ejemplares.get(0).getRecursoId() + " ha sido devuelto con exito";
    }

    public String agregarEjemplares(String recursoId, Integer cantidad){
        IntStream.range(0, cantidad)
                .forEach(element -> ejemplaresRepository.save(ejemplarMapper.fromCollection(new EjemplarDTO(recursoId, false, null))));

        return cantidad + " Ejemplares han sido agregados";
    }
}
