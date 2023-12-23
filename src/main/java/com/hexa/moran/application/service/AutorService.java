package com.hexa.moran.application.service;

import com.hexa.moran.domain.model.AutorModel;
import com.hexa.moran.domain.ports.in.AutorIn;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AutorService implements AutorIn {

    private final AutorIn autorIn;

    @Override
    public AutorModel create(AutorModel request) {
        return autorIn.create(request);
    }

    @Override
    public Optional<AutorModel> update(Long code, AutorModel request) {
        return autorIn.update(code,request);
    }

    @Override
    public Optional<AutorModel> get(Long code) {
        return autorIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return autorIn.delete(code);
    }
}
