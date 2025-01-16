package com.detocris.perdidog.service.impl;

import com.detocris.perdidog.dto.AnimalTypeDto;
import com.detocris.perdidog.models.AnimalType;
import com.detocris.perdidog.repository.AnimalTypeRepository;
import com.detocris.perdidog.service.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalTypeServiceImpl implements AnimalTypeService {


    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    public AnimalTypeServiceImpl(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public AnimalTypeDto createAnimalType(AnimalTypeDto animalTypeDto) {
        AnimalType animalType = new AnimalType();
        animalType.setName(animalTypeDto.getName());

        AnimalType newAnimal = animalTypeRepository.save(animalType);

        AnimalTypeDto animalTypeResponse = new AnimalTypeDto();
        animalTypeResponse.setId(newAnimal.getId());
        animalTypeResponse.setName(newAnimal.getName());

        return animalTypeResponse;
    }

    @Override
    public List<AnimalTypeDto> getAll() {
        List<AnimalType> animalTypes = animalTypeRepository.findAll();
        var atata = animalTypes.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return atata;
    }

    private AnimalTypeDto mapToDto(AnimalType animalType) {
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setId(animalType.getId());
        animalTypeDto.setName(animalType.getName());
        return animalTypeDto;
    }

    private AnimalType mapToEntity(AnimalTypeDto animalTypeDto) {
        AnimalType animalType = new AnimalType();
        animalType.setId(animalTypeDto.getId());
        animalType.setName(animalTypeDto.getName());
        return animalType;
    }
}
