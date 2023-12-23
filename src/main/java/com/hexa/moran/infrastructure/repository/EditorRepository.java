package com.hexa.moran.infrastructure.repository;

import com.hexa.moran.infrastructure.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorRepository extends JpaRepository<EditorEntity, Long> {
}
