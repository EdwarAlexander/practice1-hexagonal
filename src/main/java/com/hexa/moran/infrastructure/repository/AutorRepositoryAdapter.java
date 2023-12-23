package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.domain.model.AutorModel;
import com.hexa.moran.domain.ports.out.AutorOut;
import com.hexa.moran.infrastructure.entity.AutorEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class AutorRepositoryAdapter implements AutorOut {

    private final AutorRepository autorRepository;

    @Override
    public AutorModel create(AutorModel request) {
        AutorEntity autorEntity = AutorEntity.fromAutorModel(request);
        return autorRepository.save(autorEntity).fromAutorEntity();
    }

    @Override
    public Optional<AutorModel> update(Long code, AutorModel request) {
        if(autorRepository.existsById(code)){
            request.setId(code);
            AutorEntity autorEntity = AutorEntity.fromAutorModel(request);
            return Optional.of(autorRepository.save(autorEntity).fromAutorEntity());
        }
        return Optional.empty();
    }

    @Override
    public Optional<AutorModel> get(Long code) {
        return autorRepository.findById(code).map(AutorEntity::fromAutorEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(autorRepository.existsById(code)){
            autorRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
