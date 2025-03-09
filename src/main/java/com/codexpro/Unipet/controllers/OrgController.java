package com.codexpro.Unipet.controllers;

import com.codexpro.Unipet.domain.entities.Org;
import com.codexpro.Unipet.services.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orgs")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @PostMapping
    public ResponseEntity<?> registerOrg(@RequestBody Org body){
        try {
            Org org = orgService.registerOrg(
                    body.getName(),
                    body.getAuthorName(),
                    body.getEmail(),
                    body.getPassword(),
                    body.getWhatsapp(),
                    body.getCep(),
                    body.getStreet(),
                    body.getNeighborhood(),
                    body.getCity(),
                    body.getState(),
                    body.getLatitude(),
                    body.getLongitude()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(org);
        } catch (Exception e) {
            // 400: Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
