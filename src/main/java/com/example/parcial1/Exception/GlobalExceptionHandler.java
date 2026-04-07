package com.example.parcial1.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    // Captura errores de validacion (@NotBlank, @Email, @Min, etc)
    // Retorna 400 con el detalle de cada campo invalido
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String campo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(campo, mensaje);
        });
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 400);
        respuesta.put("error", "Datos invalidos");
        respuesta.put("errores", errores);
        return ResponseEntity.badRequest().body(respuesta);
    }

    // Captura cuando no se encuentra el recurso por id -> 404
    @ExceptionHandler(TareaNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(TareaNotFoundException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 404);
        respuesta.put("error", "Recurso no encontrado");
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    // Captura cualquier otra excepcion no esperada -> 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 500);
        respuesta.put("error", "Error interno del servidor");
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
    }

}
