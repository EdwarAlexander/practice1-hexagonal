package com.hexa.moran.infrastructure.controller;

import com.hexa.moran.application.service.LibroService;
import com.hexa.moran.domain.model.LibroModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/libro")
@AllArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroModel> create(@RequestBody LibroModel libroModelRequest){
        LibroModel libroModel = libroService.create(libroModelRequest);
        return new ResponseEntity<>(libroModel, HttpStatus.CREATED);
    }

    @GetMapping("/{libroId}")
    public ResponseEntity<LibroModel> get(@PathVariable Long libroId){
        return libroService.get(libroId).map(libro-> new ResponseEntity<>(libro,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{libroId}")
    public ResponseEntity<LibroModel> update(@PathVariable Long libroId, @RequestBody LibroModel libroModelRequest){
        return libroService.update(libroId, libroModelRequest).map(libro-> new ResponseEntity<>(libro,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{libroId}")
    public ResponseEntity<Void> delete(@PathVariable Long libroId){
        if(libroService.delete(libroId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
