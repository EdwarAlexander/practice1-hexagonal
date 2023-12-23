package com.hexa.moran.infrastructure.controller;

import com.hexa.moran.application.service.CategoriaService;
import com.hexa.moran.domain.model.CategoriaModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModel> create(@RequestBody CategoriaModel categoriaModelRequest){
        CategoriaModel categoriaModel = categoriaService.create(categoriaModelRequest);
        return new ResponseEntity<>(categoriaModel, HttpStatus.CREATED);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaModel> get(@PathVariable Long categoriaId){
        return categoriaService.get(categoriaId).map(categoria-> new ResponseEntity<>(categoria,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaModel> update(@PathVariable Long categoriaId, @RequestBody CategoriaModel categoriaModelRequest){
        return categoriaService.update(categoriaId, categoriaModelRequest).map(categoria-> new ResponseEntity<>(categoria, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> delete(@PathVariable Long categoriaId){
        if(categoriaService.delete(categoriaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
