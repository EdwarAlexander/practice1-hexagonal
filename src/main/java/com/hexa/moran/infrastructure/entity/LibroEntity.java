package com.hexa.moran.infrastructure.entity;

import com.hexa.moran.domain.model.AutorModel;
import com.hexa.moran.domain.model.CategoriaModel;
import com.hexa.moran.domain.model.EditorModel;
import com.hexa.moran.domain.model.LibroModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer estado;

    @OneToOne
    @JoinColumn(name = "editor_id")
    private EditorEntity editor;

    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<AutorEntity> autores = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "libro_categoria",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<CategoriaEntity> categorias = new HashSet<>();

    public LibroEntity() {
    }

    public LibroEntity(Long id, String titulo, Integer estado, EditorEntity editor, Set<AutorEntity> autores, Set<CategoriaEntity> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.estado = estado;
        this.editor = editor;
        this.autores = autores;
        this.categorias = categorias;
    }

    public static LibroEntity fromLibroModel(LibroModel libroModel){
        EditorEntity editorEntity = EditorEntity.fromEditorModel(libroModel.getEditor());
        Set<CategoriaEntity> categoriaEntitySet = libroModel.getCategorias().stream().map(categoriaModel -> CategoriaEntity.fromCategoriaModel(categoriaModel)).collect(Collectors.toSet());
        Set<AutorEntity> autorEntitySet = libroModel.getAutores().stream().map(autorModel -> AutorEntity.fromAutorModel(autorModel)).collect(Collectors.toSet());
        return new LibroEntity(libroModel.getId(), libroModel.getTitulo(), libroModel.getEstado(), editorEntity, autorEntitySet, categoriaEntitySet);
    }

    public LibroModel fromLibroEntity(){
        EditorModel editorModel = editor.fromEditorEntity();
        Set<AutorModel> autorModelSet = autores.stream().map(AutorEntity::fromAutorEntity).collect(Collectors.toSet());
        Set<CategoriaModel> categoriaModelSet = categorias.stream().map(CategoriaEntity::fromCategoriaEntity).collect(Collectors.toSet());
        return new LibroModel(id, titulo, estado, editorModel, categoriaModelSet, autorModelSet);
    }
}
