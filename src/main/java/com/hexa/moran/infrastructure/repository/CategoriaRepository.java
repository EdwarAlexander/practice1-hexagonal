package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.infrastructure.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
}
