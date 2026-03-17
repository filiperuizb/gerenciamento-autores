package com.boligon.gerenciamento_autores.repository;

import com.boligon.gerenciamento_autores.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
}
