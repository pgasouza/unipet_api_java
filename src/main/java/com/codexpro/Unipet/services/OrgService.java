package com.codexpro.Unipet.services;

import com.codexpro.Unipet.domain.entities.Org;
import com.codexpro.Unipet.repositories.InMemoryOrgsRepository;
import com.codexpro.Unipet.services.exceptions.OrgAlreadyExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    private InMemoryOrgsRepository orgsRepository;

    @Transactional
    public Org registerOrg(
            String name,
            String authorName,
            String email,
            String password,
            String whatsapp,
            String cep,
            String street,
            String neighborhood,
            String city,
            String state,
            Double latitude,
            Double longitude
    ){
        if(orgsRepository.findByEmail(email).isPresent()){
            throw new OrgAlreadyExistsException();
        }

        Org org = new Org();
        org.setName(name);
        org.setAuthorName(authorName);
        org.setEmail(email);
        org.setPassword(password);
        org.setWhatsapp(whatsapp);
        org.setCep(cep);
        org.setStreet(street);
        org.setNeighborhood(neighborhood);
        org.setCity(city);
        org.setState(state);
        org.setLatitude(latitude);
        org.setLongitude(longitude);

        return orgsRepository.create(org);
    }
}
