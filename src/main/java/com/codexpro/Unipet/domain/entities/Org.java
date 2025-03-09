package com.codexpro.Unipet.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Org {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String AuthorName;
    private String email;
    private String password;
    private String whatsapp;

    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

    private Double latitude;
    private Double longitude;

    @OneToMany
    private List<Pet> pets;
}
