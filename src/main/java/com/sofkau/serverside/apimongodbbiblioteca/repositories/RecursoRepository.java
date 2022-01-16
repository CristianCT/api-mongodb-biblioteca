package com.sofkau.serverside.apimongodbbiblioteca.repositories;

import com.sofkau.serverside.apimongodbbiblioteca.collections.Recurso;
import com.sofkau.serverside.apimongodbbiblioteca.models.RecursoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
}
