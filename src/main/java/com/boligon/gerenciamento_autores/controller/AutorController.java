package com.boligon.gerenciamento_autores.controller;

import com.boligon.gerenciamento_autores.entity.AutorEntity;
import com.boligon.gerenciamento_autores.service.AutorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

        @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorEntity> save(@RequestBody AutorEntity novoAutor) {
        AutorEntity autor = autorService.save(novoAutor);
        return ResponseEntity.status(201).body(autor);
    }

    @GetMapping
    public ResponseEntity<List<AutorEntity>> findAll() {
        List<AutorEntity> autorList = autorService.findAll();
        return autorList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(autorList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> findById(@PathVariable Long id) {
        Optional<AutorEntity> autor = autorService.findById(id);
        return autor.isPresent()
                ? ResponseEntity.ok().body(autor.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        autorService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
