package com.detocris.perdidog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LostPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date reportDate;
    private boolean isActive;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animalTypeId")
    private AnimalType animalType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genderId")
    private Gender gender;


}
