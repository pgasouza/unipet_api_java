package unipet.api.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unipet.api.springboot.Entities.Org;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrgRepository extends JpaRepository<Org, UUID> {
    Optional<Org> findByEmail(String email);
}
