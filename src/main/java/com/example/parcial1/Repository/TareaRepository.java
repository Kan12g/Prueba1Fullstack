package com.example.parcial1.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.parcial1.Model.Tarea;



@Repository
public class TareaRepository {
    private List<Tarea> listaTarea = new ArrayList<>();


    public TareaRepository() {
        listaTarea.add(new Tarea(123L, "Matemaricas", "Activo", "De suma importancia", "si", "20/10/2026"));
        listaTarea.add(new Tarea(134L, "Fullstack", "Activo", "De suma importancia", "si", "23/11/2026"));
        listaTarea.add(new Tarea(123L, "Religion", "Activo", "No es importante", "si", "25/03/2027"));
    }

    public Tarea registrarTareaNuevas(Tarea tarea){
        listaTarea.add(tarea);
        return tarea;

    }

    public List<Tarea> consultarTareasAlmacenadas(){
        return listaTarea;
    }


    public List<Tarea> obtenerPorCriterio(String prioridad){
        List<Tarea> resultado = new ArrayList<>();
        for(Tarea t : listaTarea){
            if(t.getPrioridad().equalsIgnoreCase(prioridad)){
                resultado.add(t);
            }
        }
        return resultado;
    }
    

    public Tarea buscarPorId(int id){
        for(Tarea t : listaTarea){
            if(t.getIdTarea() == id){
                return t;
            }
        }
        return null;

    }

    
    public void eliminarTarea(int id){
        listaTarea.removeIf(t -> t.getIdTarea() == id);
    }

    public Tarea actualizarTarea(Tarea tarea){
        int idP = 0;
        for(int i = 0; i < listaTarea.size(); i ++){
            if (listaTarea.get(i).getIdTarea() == tarea.getIdTarea()){
                idP = i;
            }
        }
        listaTarea.set(idP, tarea);
        return tarea;
    }




}
