package com.hexa.moran.infrastructure.controller;

import com.hexa.moran.application.service.AutorService;
import com.hexa.moran.domain.model.AutorModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/autor")
@AllArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModel> create(@RequestBody AutorModel autorModelRequest){
        AutorModel autorModel = autorService.create(autorModelRequest);
        return new ResponseEntity<>(autorModel, HttpStatus.CREATED);
    }

    @GetMapping("/{autorId}")
    public ResponseEntity<AutorModel> get(@PathVariable Long autorId){
        return autorService.get(autorId).map(autor-> new ResponseEntity<>(autor,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{autorId}")
    public ResponseEntity<AutorModel> update(@PathVariable Long autorId, @RequestBody AutorModel autorModelRequest){
        return autorService.update(autorId, autorModelRequest).map(autor-> new ResponseEntity<>(autor,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{autorId}")
    public ResponseEntity<Void> delete(@PathVariable Long autorId){
        if(autorService.delete(autorId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
