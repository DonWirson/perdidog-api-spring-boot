package com.detocris.perdidog.controllers;

import com.detocris.perdidog.dto.AnimalTypeDto;
import com.detocris.perdidog.service.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AnimalTypeController {
    private AnimalTypeService animalTypeService;

    @Autowired
    public AnimalTypeController(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }

    @GetMapping("AnimalType")
    public ResponseEntity<List<AnimalTypeDto>> getAll() {
        return ResponseEntity.ok(animalTypeService.getAll());
    }

    @GetMapping("AnimalType/{id}")
    public ResponseEntity<AnimalTypeDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(animalTypeService.getById(id));
    }

    @PostMapping("AnimalType")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnimalTypeDto> create(@RequestBody AnimalTypeDto animalTypeDto) {

        return new ResponseEntity<>(animalTypeService.createAnimalType(animalTypeDto), HttpStatus.CREATED);
    }

    @PutMapping("AnimalType/{id}")
    public ResponseEntity<AnimalTypeDto> update(@PathVariable int id, @RequestBody AnimalTypeDto animalType) {
        var response = animalTypeService.update(id, animalType);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("AnimalType/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        animalTypeService.delete(id);
        return ResponseEntity.ok(true);

    }
}
