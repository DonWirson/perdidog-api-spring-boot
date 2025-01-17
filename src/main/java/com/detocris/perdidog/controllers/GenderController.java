package com.detocris.perdidog.controllers;

import com.detocris.perdidog.dto.GenderDto;
import com.detocris.perdidog.models.Gender;
import com.detocris.perdidog.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }


    @GetMapping("Gender")

    public ResponseEntity<List<GenderDto>> getAll() {
        var gendersDto = genderService.getAll();
        System.out.println(gendersDto);
        return ResponseEntity.ok(gendersDto);
    }

    @GetMapping("Gender/{id}")
    public ResponseEntity<GenderDto> getById(@PathVariable int id) {
        GenderDto gender = genderService.getById(id);
        return ResponseEntity.ok(gender);
    }


    @PostMapping("Gender")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GenderDto> create(@RequestBody GenderDto genderDto) {
        var newGender = genderService.createGender(genderDto);
        return new ResponseEntity<>(newGender, HttpStatus.CREATED);
    }

    @PutMapping("Gender/{id}")
    public ResponseEntity<GenderDto> update(@PathVariable int id, @RequestBody GenderDto genderDto) {
        return new ResponseEntity<>(genderService.update(id, genderDto), HttpStatus.OK);
    }

    @DeleteMapping("Gender/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        genderService.delete(id);
        return ResponseEntity.ok(true);
    }

}
