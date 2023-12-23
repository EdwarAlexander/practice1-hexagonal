package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.domain.model.LibroModel;
import com.hexa.moran.domain.ports.out.LibroOut;
import com.hexa.moran.infrastructure.entity.LibroEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class LibroRepositoryAdapter implements LibroOut {

    private final LibroRepository libroRepository;

    @Override
    public LibroModel create(LibroModel request) {
        LibroEntity libroEntity = LibroEntity.fromLibroModel(request);
        return libroRepository.save(libroEntity).fromLibroEntity();
    }

    @Override
    public Optional<LibroModel> update(Long code, LibroModel request) {
        if(libroRepository.existsById(code)){
            request.setId(code);
            LibroEntity libroEntity = LibroEntity.fromLibroModel(request);
            return Optional.of(libroRepository.save(libroEntity).fromLibroEntity());
        }
        return Optional.empty();
    }

    @Override
    public Optional<LibroModel> get(Long code) {
        return libroRepository.findById(code).map(LibroEntity::fromLibroEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(libroRepository.existsById(code)){
            libroRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
