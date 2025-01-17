package com.detocris.perdidog.service;

import com.detocris.perdidog.dto.GenderDto;

import java.util.List;

public interface GenderService {

    List<GenderDto> getAll();

    GenderDto getById(int id);

    GenderDto createGender(GenderDto genderDto);

    GenderDto update(int id, GenderDto genderDto);

    void delete(int id);
}
