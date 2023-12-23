package com.hexa.moran.infrastructure.controller;

import com.hexa.moran.application.service.EditorService;
import com.hexa.moran.domain.model.EditorModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/editor")
@AllArgsConstructor
public class EditorController {

    private final EditorService editorService;

    @PostMapping
    public ResponseEntity<EditorModel> create(@RequestBody EditorModel editorModelRequest){
        EditorModel editorModel = editorService.create(editorModelRequest);
        return new ResponseEntity<>(editorModel, HttpStatus.CREATED);
    }

    @GetMapping("/{editorId}")
    public ResponseEntity<EditorModel> get(@PathVariable Long editorId){
        return editorService.get(editorId).map(editor-> new ResponseEntity<>(editor,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{editorId}")
    public ResponseEntity<EditorModel> update(@PathVariable Long editorId, @RequestBody EditorModel editorModelRequest){
        return editorService.update(editorId, editorModelRequest).map(editor-> new ResponseEntity<>(editor,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{editorId}")
    public ResponseEntity<Void> delete(@PathVariable Long editorId){
        if(editorService.delete(editorId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
