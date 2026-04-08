package com.example.parcial1.Exception;

public class TareaNotFoundException extends RuntimeException{

    public TareaNotFoundException(int id) {
        super("Tarea " + id + " no encontrado/a");
    }

}
