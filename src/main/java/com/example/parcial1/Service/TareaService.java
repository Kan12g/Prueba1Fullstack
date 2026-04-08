package com.example.parcial1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parcial1.Exception.TareaNotFoundException;
import com.example.parcial1.Model.Tarea;
import com.example.parcial1.Repository.TareaRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;


    public Tarea saveTarea(Tarea obj){
        return tareaRepository.registrarTareaNuevas(obj);

    }

    public List<Tarea> getobtenerPorCriterio(){
        return tareaRepository.obtenerPorCriterio(null);
    }

    public List<Tarea> getTareas(){
        return tareaRepository.consultarTareasAlmacenadas();
    }

    public Tarea updateTarea(int id, Tarea obj){
        if (tareaRepository.buscarPorId(id)== null) throw new TareaNotFoundException(id);
        return tareaRepository.actualizarTarea(obj);
    }

    public String deleteTarea(int id){
        if(tareaRepository.buscarPorId(id) == null) throw new TareaNotFoundException(id);
        tareaRepository.eliminarTarea(id);
        return "Tarea Eliminada";
    }

    public Tarea getTareaPorId(int id){
        Tarea obj = tareaRepository.buscarPorId(id);
        if(obj == null) throw new TareaNotFoundException(id);
        return obj;
    }


}
