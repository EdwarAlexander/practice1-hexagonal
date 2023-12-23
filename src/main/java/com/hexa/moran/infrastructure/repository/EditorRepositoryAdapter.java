package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.domain.model.EditorModel;
import com.hexa.moran.domain.ports.out.EditorOut;
import com.hexa.moran.infrastructure.entity.EditorEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EditorRepositoryAdapter implements EditorOut {

    private final EditorRepository editorRepository;

    @Override
    public EditorModel create(EditorModel request) {
        EditorEntity editorEntity = EditorEntity.fromEditorModel(request);
        return editorRepository.save(editorEntity).fromEditorEntity();
    }

    @Override
    public Optional<EditorModel> update(Long code, EditorModel request) {
        if(editorRepository.existsById(code)){
            request.setId(code);
            EditorEntity editorEntity = EditorEntity.fromEditorModel(request);
            return Optional.of(editorRepository.save(editorEntity).fromEditorEntity());
        }
        return Optional.empty();
    }

    @Override
    public Optional<EditorModel> get(Long code) {
        return editorRepository.findById(code).map(EditorEntity::fromEditorEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(editorRepository.existsById(code)){
            editorRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
