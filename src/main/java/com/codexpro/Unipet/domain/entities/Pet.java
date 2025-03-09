package com.codexpro.Unipet.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String about;
    private String age;
    private String size;
    private String energyLevel;
    private String environment;

    @ManyToOne
    private Org org;

}
