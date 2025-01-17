package com.detocris.perdidog.repository;

import com.detocris.perdidog.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
