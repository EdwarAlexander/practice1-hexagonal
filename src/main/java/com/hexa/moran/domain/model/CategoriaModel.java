package com.hexa.moran.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaModel {
    private Long id;
    private String nombre;
    private Integer estado;
}
