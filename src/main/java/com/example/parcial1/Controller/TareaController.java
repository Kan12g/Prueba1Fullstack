package com.example.parcial1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcial1.Model.Tarea;
import com.example.parcial1.Service.TareaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/evaluacion/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping()
    public ResponseEntity<Tarea> agregarTarea(@Validated @RequestBody Tarea tarea){
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.saveTarea(tarea));
    }
    
    
    @GetMapping()
    public ResponseEntity<List<Tarea>> buscarPorCriterio(@PathVariable String prioridad){
        return ResponseEntity.ok((tareaService.getobtenerPorCriterio()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarea> buscarTarea(@PathVariable int id){
        return ResponseEntity.ok(tareaService.getTareaPorId(id));
    }
    

    @PutMapping("{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable int id, @Validated @RequestBody Tarea tarea){
        return ResponseEntity.ok(tareaService.updateTarea(id, tarea));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarea> eliminarTarea(@PathVariable int id){
            tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }

}
