package com.hexa.moran.infrastructure.entity;

import com.hexa.moran.domain.model.CategoriaModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer estado;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public static CategoriaEntity fromCategoriaModel(CategoriaModel categoriaModel){
        return new CategoriaEntity(categoriaModel.getId(), categoriaModel.getNombre(), categoriaModel.getEstado());
    }

    public CategoriaModel fromCategoriaEntity(){
        return new CategoriaModel(id, nombre, estado);
    }
}
