package unipet.api.springboot.entity;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orgs") 
public class Org {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    
    @Column(name = "author_name") 
    private String authorName;

    @Column(unique = true)
    private String email;

    private String password;
    private String whatsapp;
    
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    
    private BigDecimal latitude;
    private BigDecimal longitude;

    @OneToMany(mappedBy = "org", cascade = CascadeType.ALL)
    private List<Pet> pets;
}
