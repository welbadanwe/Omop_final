package fr.bordeaux.isped.sitis.omop_group_project.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "person_mapping", schema = "omop")
public class PersonMapping {
    @Column(name = "person_ide")
    private String personIde;

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "omop.seq_pat", schema = "omop", initialValue = 1, allocationSize = 1)
    private Integer personId;

    //Constructors

    public PersonMapping() {
    }


    //Getters and Setters

    public String getPersonIde() {
        return personIde;
    }

    public void setPersonIde(String personIde) {
        this.personIde = personIde;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
