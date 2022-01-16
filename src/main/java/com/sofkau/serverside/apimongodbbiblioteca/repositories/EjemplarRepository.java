package com.sofkau.serverside.apimongodbbiblioteca.repositories;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Ejemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EjemplarRepository extends MongoRepository<Ejemplar, String> {

    List<Ejemplar> findByRecursoId(String RecursoId);

    List<Ejemplar> findByRecursoIdAndPrestado(String RecursoId, Boolean prestado);
}
