package com.detocris.perdidog.repository;

import com.detocris.perdidog.models.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {
}
