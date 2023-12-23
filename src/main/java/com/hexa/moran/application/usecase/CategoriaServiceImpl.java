package com.hexa.moran.application.usecase;

import com.hexa.moran.domain.model.CategoriaModel;
import com.hexa.moran.domain.ports.in.CategoriaIn;
import com.hexa.moran.domain.ports.out.CategoriaOut;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaIn {

    private final CategoriaOut categoriaOut;
    @Override
    public CategoriaModel create(CategoriaModel request) {
        return categoriaOut.create(request);
    }

    @Override
    public Optional<CategoriaModel> update(Long code, CategoriaModel request) {
        return categoriaOut.update(code, request);
    }

    @Override
    public Optional<CategoriaModel> get(Long code) {
        return categoriaOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return categoriaOut.delete(code);
    }
}
