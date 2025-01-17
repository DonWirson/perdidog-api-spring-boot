package com.detocris.perdidog.service.impl;

import com.detocris.perdidog.dto.GenderDto;
import com.detocris.perdidog.exceptions.NotFoundException;
import com.detocris.perdidog.models.Gender;
import com.detocris.perdidog.repository.GenderRepository;
import com.detocris.perdidog.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements GenderService {

    public GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public List<GenderDto> getAll() {
        List<Gender> genders = genderRepository.findAll();
        System.out.println(genders);
        return genders.stream().map((gender) -> toDto(gender)).collect(Collectors.toList());
    }

    @Override
    public GenderDto getById(int id) {
        Gender gender = genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Gender not found"));
        return toDto(gender);
    }

    @Override
    public GenderDto createGender(GenderDto genderDto) {
        Gender gender = new Gender();
        gender.setName(genderDto.getName());

        Gender newGender = genderRepository.save(gender);
        return toDto(newGender);
    }

    @Override
    public GenderDto update(int id, GenderDto genderDto) {
        Gender gender = genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Gender not found"));
        gender.setName(genderDto.getName());

        var updatedGender = genderRepository.save(gender);

        return toDto(updatedGender);
    }

    @Override
    public void delete(int id) {
        Gender gender = genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Gender not found"));
        genderRepository.delete(gender);
    }

    private GenderDto toDto(Gender gender) {
        var genderDto = new GenderDto();
        genderDto.setName(gender.getName());
        genderDto.setId(gender.getId());
        return genderDto;
    }

    private Gender toEntity(GenderDto genderDto) {
        var gender = new Gender();
        gender.setId(genderDto.getId());
        gender.setName(genderDto.getName());
        return gender;
    }
}
