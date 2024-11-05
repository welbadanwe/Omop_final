package fr.bordeaux.isped.sitis.omop_group_project.service;

import fr.bordeaux.isped.sitis.omop_group_project.repository.PersonMappingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonMappingService {

    private final PersonMappingRepository personMappingRepository;

    @Autowired
    public PersonMappingService(PersonMappingRepository personMappingRepository) {
        this.personMappingRepository = personMappingRepository;
    }

    @PostConstruct
    public void initializeSequence() {
        personMappingRepository.createPersonIdSequence();
    }

    @Transactional
    public void mapPatIdToPersonIde() {
        personMappingRepository.mapPatIdToPersonIde();
    }

    @Transactional
    public void truncateTables() {
        // Truncate les tables
        personMappingRepository.truncatePersonMappingTable();
        personMappingRepository.truncatePersonTable();
        // Redémarrer les séquences
        personMappingRepository.restartSequences();
    }

    @Transactional
    public void insertTransformedPatients() {
        personMappingRepository.insertTransformedPatients();
    }
}
