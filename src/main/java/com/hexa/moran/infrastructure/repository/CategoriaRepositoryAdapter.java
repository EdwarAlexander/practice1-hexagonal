package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.domain.model.CategoriaModel;
import com.hexa.moran.domain.ports.out.CategoriaOut;
import com.hexa.moran.infrastructure.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoriaRepositoryAdapter implements CategoriaOut {

    private CategoriaRepository categoriaRepository;
    @Override
    public CategoriaModel create(CategoriaModel request) {
        CategoriaEntity categoriaEntity = CategoriaEntity.fromCategoriaModel(request);
        return categoriaRepository.save(categoriaEntity).fromCategoriaEntity();
    }

    @Override
    public Optional<CategoriaModel> update(Long code, CategoriaModel request) {
        if(categoriaRepository.existsById(code)){
            request.setId(code);
            CategoriaEntity categoriaEntity = CategoriaEntity.fromCategoriaModel(request);
            return Optional.of(categoriaRepository.save(categoriaEntity).fromCategoriaEntity());
        }
        return Optional.empty();
    }

    @Override
    public Optional<CategoriaModel> get(Long code) {
        return categoriaRepository.findById(code).map(CategoriaEntity::fromCategoriaEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(categoriaRepository.existsById(code)){
            categoriaRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
