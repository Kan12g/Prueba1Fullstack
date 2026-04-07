package com.example.parcial1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //Aqui lo que deberia de hacer es tener listo el obtenerPorCriterio para seguir aca
        //if (tareaRepository.))
        //Sacar el return null
        return null;
    }



}
