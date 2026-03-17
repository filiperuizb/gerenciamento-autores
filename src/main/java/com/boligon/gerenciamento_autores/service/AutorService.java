package com.boligon.gerenciamento_autores.service;

import com.boligon.gerenciamento_autores.entity.AutorEntity;
import com.boligon.gerenciamento_autores.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorEntity save(AutorEntity novoAutor) {
        return autorRepository.save(novoAutor);
    }

    public Optional<AutorEntity> findById(Long id) {
        return autorRepository.findById(id);
    }

    public List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }
}
