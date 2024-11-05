package fr.bordeaux.isped.sitis.omop_group_project.web.controller;

import fr.bordeaux.isped.sitis.omop_group_project.service.PersonMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonMappingController {

    private final PersonMappingService personMappingService;

    @Autowired
    public PersonMappingController(PersonMappingService personMappingService) {
        this.personMappingService = personMappingService;
    }

    @PostMapping("/truncate-tables")
    public ResponseEntity<String> truncateTables() {
        try {
            personMappingService.truncateTables();
            return ResponseEntity.ok("Tables truncated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Truncation failed: " + e.getMessage());
        }
    }


    @PostMapping("/alimentating-ids")
    public ResponseEntity<String> mapPatIdToPersonIde() {
        try {
            personMappingService.mapPatIdToPersonIde();
            return ResponseEntity.ok("Mapping successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Mapping failed: " + e.getMessage());
        }
    }


    @PostMapping("/insert-transformed-patients")
    public ResponseEntity<String> insertTransformedPatients() {
        try {
            personMappingService.insertTransformedPatients();
            return ResponseEntity.ok("Insertion successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Insertion failed: " + e.getMessage());
        }
    }
}
