package com.hexa.moran.infrastructure.entity;

import com.hexa.moran.domain.model.EditorModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "editor")
public class EditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer estado;

    public EditorEntity() {
    }

    public EditorEntity(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public static EditorEntity fromEditorModel(EditorModel editorModel){
        return new EditorEntity(editorModel.getId(), editorModel.getNombre(), editorModel.getEstado());
    }

    public EditorModel fromEditorEntity(){
        return new EditorModel(id, nombre, estado);
    }
}
