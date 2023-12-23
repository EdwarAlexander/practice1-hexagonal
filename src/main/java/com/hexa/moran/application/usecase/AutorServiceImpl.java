package com.hexa.moran.application.usecase;

import com.hexa.moran.domain.model.AutorModel;
import com.hexa.moran.domain.ports.in.AutorIn;
import com.hexa.moran.domain.ports.out.AutorOut;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AutorServiceImpl implements AutorIn {

    private final AutorOut autorOut;
    @Override
    public AutorModel create(AutorModel request) {
        return autorOut.create(request);
    }

    @Override
    public Optional<AutorModel> update(Long code, AutorModel request) {
        return autorOut.update(code, request);
    }

    @Override
    public Optional<AutorModel> get(Long code) {
        return autorOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return autorOut.delete(code);
    }
}
