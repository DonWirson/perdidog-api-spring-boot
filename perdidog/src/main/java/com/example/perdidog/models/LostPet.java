package com.example.perdidog.models;

import com.example.perdidog.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LostPets")
public class LostPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalType;
    private String name;
    private Gender gender;
    @CreationTimestamp
    private LocalDateTime reportDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    private boolean isActive;

}
