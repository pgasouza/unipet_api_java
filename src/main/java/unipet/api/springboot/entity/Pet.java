package unipet.api.springboot.entity;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets") // Mapeia para a tabela "pets" no banco de dados
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Gera um UUID automaticamente

    private String name;
    private String about;
    private String age;
    private String size;
    
    @Column(name = "energy_level")
    private String energyLevel;

    private String environment;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false) // Chave estrangeira para "orgs"
    private Org org;
}
