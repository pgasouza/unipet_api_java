package unipet.api.springboot.Controllers;

import unipet.api.springboot.Entities.Org;
import unipet.api.springboot.Services.OrgService;
import unipet.api.springboot.Services.Execeptions.OrgAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orgs")
public class OrgController {

    private final OrgService orgService;

    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping
    public ResponseEntity<?> registerOrg(@RequestBody Org orgRequest) {
        try {
            Org org = orgService.registerOrg(
                    orgRequest.getName(),
                    orgRequest.getAuthorName(),
                    orgRequest.getEmail(),
                    orgRequest.getPassword(),
                    orgRequest.getWhatsapp(),
                    orgRequest.getCep(),
                    orgRequest.getStreet(),
                    orgRequest.getNeighborhood(),
                    orgRequest.getCity(),
                    orgRequest.getState(),
                    orgRequest.getLatitude(),
                    orgRequest.getLongitude()
            );
            return ResponseEntity.ok(org);
        } catch (OrgAlreadyExistsException e) {
            // 400: Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}