package com.codexpro.Unipet.repositories;

import com.codexpro.Unipet.domain.entities.Org;
import com.codexpro.Unipet.repositories.interfaces.OrgsRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryOrgsRepository implements OrgsRepositoryInterface {
    private final List<Org> items = new ArrayList<>();

    @Override
    public Optional<Org> findByEmail(String email) {
        return items.stream().filter(org -> org.getEmail().equals(email)).findFirst();
    }

    @Override
    public Optional<Org> findById(String id) {
        return items.stream().filter(org -> org.getId().toString().equals(id)).findFirst();
    }

    @Override
    public Org create (Org org){
        org.setId(UUID.randomUUID());
        items.add(org);

        return org;
    }
}
