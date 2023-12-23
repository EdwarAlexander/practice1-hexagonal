package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.infrastructure.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
}
