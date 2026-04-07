package com.example.parcial1.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.parcial1.Model.Tarea;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Repository
public class TareaRepository {
    private List<Tarea> listaTarea = new ArrayList<>();

    public Tarea registrarTareaNuevas(Tarea tarea){
        listaTarea.add(tarea);
        return tarea;

    }

    public List<Tarea> consultarTareasAlmacenadas(){
        return listaTarea;
    }


    //Cambiar esto por la estructura del buscar por id, pero dejamos el nombre obtenerPorCriterio
    public List<Tarea> obtenerPorCriterio(String prioridad){
        List<Tarea> resultado = new ArrayList<>();
        for(Tarea t : listaTarea){
            if(t.getPrioridad().equalsIgnoreCase(prioridad)){
                resultado.add(t);
            }
        }
        return resultado;
    }
    
    
    public void eliminarTarea(Long id){
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
