package com.detocris.perdidog.service;

import com.detocris.perdidog.dto.AnimalTypeDto;
import com.detocris.perdidog.models.AnimalType;

import java.util.List;

public interface AnimalTypeService {
    AnimalTypeDto createAnimalType(AnimalTypeDto animalTypeDto);

    List<AnimalTypeDto> getAll();
}
