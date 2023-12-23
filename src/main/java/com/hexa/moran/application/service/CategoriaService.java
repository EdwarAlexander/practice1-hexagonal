package com.hexa.moran.application.service;

import com.hexa.moran.domain.model.CategoriaModel;
import com.hexa.moran.domain.ports.in.CategoriaIn;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CategoriaService implements CategoriaIn {

    private final CategoriaIn categoriaIn;
    @Override
    public CategoriaModel create(CategoriaModel request) {
        return categoriaIn.create(request);
    }

    @Override
    public Optional<CategoriaModel> update(Long code, CategoriaModel request) {
        return categoriaIn.update(code, request);
    }

    @Override
    public Optional<CategoriaModel> get(Long code) {
        return categoriaIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return categoriaIn.delete(code);
    }
}
