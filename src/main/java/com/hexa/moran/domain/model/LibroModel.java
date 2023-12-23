package com.hexa.moran.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LibroModel {

    private Long id;
    private String titulo;
    private Integer estado;
    private EditorModel editor;
    private Set<CategoriaModel> categorias = new HashSet<>();
    private Set<AutorModel> autores = new HashSet<>();
}
