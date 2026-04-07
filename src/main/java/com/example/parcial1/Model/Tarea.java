package com.example.parcial1.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarea")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarea {

    @Id
    private Long idTarea;

    @Column(nullable = false)
    private String Descripcion;
    
    @Column(nullable = false)
    private String Prioridad;

    @Column(nullable = false)
    private String FechaAsociada;

    


}
