package com.codexpro.Unipet.repositories.interfaces;

import com.codexpro.Unipet.domain.entities.Org;

import java.util.Optional;

public interface OrgsRepositoryInterface {
    Optional<Org> findByEmail(String email);
    Optional<Org> findById(String id);
    Org create(Org org);
}
