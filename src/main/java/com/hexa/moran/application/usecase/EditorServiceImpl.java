package com.hexa.moran.application.usecase;

import com.hexa.moran.domain.model.EditorModel;
import com.hexa.moran.domain.ports.in.EditorIn;
import com.hexa.moran.domain.ports.out.EditorOut;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class EditorServiceImpl implements EditorIn {

    private final EditorOut editorOut;

    @Override
    public EditorModel create(EditorModel request) {
        return editorOut.create(request);
    }

    @Override
    public Optional<EditorModel> update(Long code, EditorModel request) {
        return editorOut.update(code, request);
    }

    @Override
    public Optional<EditorModel> get(Long code) {
        return editorOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return editorOut.delete(code);
    }
}
