package unipet.api.springboot.Services;

import unipet.api.springboot.Repositories.OrgRepository;
import unipet.api.springboot.Services.Execeptions.OrgAlreadyExistsException;
import unipet.api.springboot.Entities.Org;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrgService {

    private final OrgRepository orgRepository;

    public OrgService(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

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
    ) {
        if (orgRepository.findByEmail(email).isPresent()) {
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

        return orgRepository.save(org);
    }
}