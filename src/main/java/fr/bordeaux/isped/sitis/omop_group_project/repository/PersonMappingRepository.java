package fr.bordeaux.isped.sitis.omop_group_project.repository;

import fr.bordeaux.isped.sitis.omop_group_project.domain.PersonMapping;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonMappingRepository extends JpaRepository<PersonMapping, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO omop.person_mapping (person_id, person_ide) 
        SELECT nextval('omop.seq_pat'), pat_id 
        FROM synthetic_snds.tab_patient
    """, nativeQuery = true)
    void mapPatIdToPersonIde();

    @Modifying
    @Transactional
    @Query(value = """
        CREATE SEQUENCE IF NOT EXISTS omop.person_id_seq START 1;
        ALTER TABLE omop.person ALTER COLUMN person_id SET DEFAULT nextval('omop.person_id_seq');
    """, nativeQuery = true)
    void createPersonIdSequence();

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE omop.person_mapping", nativeQuery = true)
    void truncatePersonMappingTable();

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE omop.person", nativeQuery = true)
    void truncatePersonTable();

    @Modifying
    @Transactional
    @Query(value = """
        ALTER SEQUENCE omop.seq_pat RESTART WITH 1;
        ALTER SEQUENCE omop.person_id_seq RESTART WITH 1; 
    """, nativeQuery = true)
    void restartSequences();

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO omop.person (
            person_id,
            gender_concept_id,
            year_of_birth,
            month_of_birth,
            day_of_birth,
            location_id,
            race_concept_id,
            ethnicity_concept_id
        )
        SELECT
            pm.person_id,
            tp.pat_sex_cod AS gender_concept_id,
            EXTRACT(YEAR FROM tp.pat_birth_date) AS year_of_birth,
            EXTRACT(MONTH FROM tp.pat_birth_date) AS month_of_birth,
            EXTRACT(DAY FROM tp.pat_birth_date) AS day_of_birth,
            tp.pat_dpt_res AS location_id,
            0 AS race_concept_id,
            0 AS ethnicity_concept_id
        FROM
            synthetic_snds.tab_patient tp
        JOIN
            omop.person_mapping pm ON tp.pat_id = pm.person_ide
    """, nativeQuery = true)
    void insertTransformedPatients();
}
