package com.hexa.moran.application.usecase;

import com.hexa.moran.domain.model.LibroModel;
import com.hexa.moran.domain.ports.in.LibroIn;
import com.hexa.moran.domain.ports.out.LibroOut;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class LibroServiceImpl implements LibroIn {

    private final LibroOut libroOut;

    @Override
    public LibroModel create(LibroModel request) {
        return libroOut.create(request);
    }

    @Override
    public Optional<LibroModel> update(Long code, LibroModel request) {
        return libroOut.update(code, request);
    }

    @Override
    public Optional<LibroModel> get(Long code) {
        return libroOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return libroOut.delete(code);
    }
}
