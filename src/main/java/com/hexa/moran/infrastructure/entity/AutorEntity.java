package com.hexa.moran.infrastructure.entity;

import com.hexa.moran.domain.model.AutorModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer estado;

    public AutorEntity(){

    }

    public AutorEntity(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public static AutorEntity fromAutorModel(AutorModel autorModel){
        return new AutorEntity(autorModel.getId(), autorModel.getNombre(), autorModel.getEstado());
    }

    public AutorModel fromAutorEntity(){
        return new AutorModel(id,nombre,estado);
    }
}
