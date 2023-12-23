package com.hexa.moran.application.service;

import com.hexa.moran.domain.model.LibroModel;
import com.hexa.moran.domain.ports.in.LibroIn;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class LibroService implements LibroIn {

    private final LibroIn libroIn;

    @Override
    public LibroModel create(LibroModel request) {
        return libroIn.create(request);
    }

    @Override
    public Optional<LibroModel> update(Long code, LibroModel request) {
        return libroIn.update(code, request);
    }

    @Override
    public Optional<LibroModel> get(Long code) {
        return libroIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return libroIn.delete(code);
    }
}
