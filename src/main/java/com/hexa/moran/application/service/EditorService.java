package com.hexa.moran.application.service;

import com.hexa.moran.domain.model.EditorModel;
import com.hexa.moran.domain.ports.in.EditorIn;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class EditorService implements EditorIn {

    private final EditorIn editorIn;

    @Override
    public EditorModel create(EditorModel request) {
        return editorIn.create(request);
    }

    @Override
    public Optional<EditorModel> update(Long code, EditorModel request) {
        return editorIn.update(code, request);
    }

    @Override
    public Optional<EditorModel> get(Long code) {
        return editorIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return editorIn.delete(code);
    }
}
