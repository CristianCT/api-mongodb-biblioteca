package com.sofkau.serverside.apimongodbbiblioteca.controllers;

import com.sofkau.serverside.apimongodbbiblioteca.models.RecursoDTO;
import com.sofkau.serverside.apimongodbbiblioteca.services.EjemplarService;
import com.sofkau.serverside.apimongodbbiblioteca.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping("/{recursoId}")
    public ResponseEntity<String> consultarDisponibilidad(@PathVariable("recursoId") String recursoId){
        return new ResponseEntity(ejemplarService.consultarDisponibilidad(recursoId), HttpStatus.OK);
    }

    @PutMapping("/prestar/{recursoId}")
    public ResponseEntity<String> prestarRecurso(@PathVariable("recursoId") String recursoId){
        return new ResponseEntity(ejemplarService.prestarRecurso(recursoId), HttpStatus.OK);
    }

    @PutMapping("/devolver/{recursoId}")
    public ResponseEntity<String> devolverRecurso(@PathVariable("recursoId") String recursoId){
        return new ResponseEntity(ejemplarService.devolverRecurso(recursoId), HttpStatus.OK);
    }

    @PostMapping("/agregar/{recursoId}")
    public ResponseEntity<String> agregarEjemplar(@PathVariable("recursoId") String recursoId){
        return new ResponseEntity(ejemplarService.agregarEjemplares(recursoId, 1), HttpStatus.OK);
    }

    @PostMapping("/agregar/{recursoId}/{cantidad}")
    public ResponseEntity<String> agregarEjemplares(@PathVariable("recursoId") String recursoId, @PathVariable("cantidad") Integer cantidad){
        return new ResponseEntity(ejemplarService.agregarEjemplares(recursoId, cantidad), HttpStatus.OK);
    }

    @GetMapping("/recomendar/{tipo}/{areaTematica}")
    public ResponseEntity<List<RecursoDTO>> recomendarRecursos(@PathVariable("tipo") String tipo, @PathVariable("areaTematica") String areaTematica){
        return new ResponseEntity(recursoService.filtrarRecursosPorTipoYAreaTematica(tipo, areaTematica), HttpStatus.OK);
    }

    @GetMapping("recomendar/tipo/{tipo}")
    public ResponseEntity<List<RecursoDTO>> recomendarRecursoPorTipo(@PathVariable("tipo") String tipo){
        return new ResponseEntity(recursoService.filtrarRecursosPorTipo(tipo), HttpStatus.OK);
    }

    @GetMapping("recomendar/area/{areaTemarica}")
    public ResponseEntity<List<RecursoDTO>> recomendarRecursoPorArea(@PathVariable("areaTematica") String areaTematica){
        return new ResponseEntity(recursoService.filtrarRecursosPorAreaTematica(areaTematica), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> obtenerRecursos() {
        return new ResponseEntity(recursoService.obtenerRecursos(), HttpStatus.OK);
    }

    @PutMapping("/{recursoId}")
    public ResponseEntity<RecursoDTO> actualoizarRecurso(@PathVariable("recursoId") String recursoId, @RequestBody RecursoDTO recursoDTO){
        return new ResponseEntity(recursoService.actualizarRecurso(recursoId, recursoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{recursoId}")
    public ResponseEntity<RecursoDTO> eliminarRecurso(@PathVariable("recursoId") String recursoId){
        return new ResponseEntity(recursoService.eliminarRecurso(recursoId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecursoDTO> crearRecurso(@RequestBody RecursoDTO recursoDTO){
        return new ResponseEntity(recursoService.crearRecurso(recursoDTO), HttpStatus.OK);
    }
}
