package fr.bordeaux.isped.sitis.omop_group_project.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "person", schema = "omop")
public class PersonDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "omop.seq_person", allocationSize = 1)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "gender_concept_id")
    private Integer genderConceptId;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(name = "month_of_birth")
    private Integer monthOfBirth;

    @Column(name = "day_of_birth")
    private Integer dayOfBirth;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "race_concept_id")
    private Integer raceConceptId;

    @Column(name = "ethnicity_concept_id")
    private Integer ethnicityConceptId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "care_site_id")
    private Integer careSiteId;

    @Column(name = "person_source_value")
    private String personSourceValue;

    @Column(name = "gender_source_value")
    private String genderSourceValue;

    @Column(name = "gender_source_concept_id")
    private Integer genderSourceConceptId;

    @Column(name = "race_source_value")
    private String raceSourceValue;

    @Column(name = "race_source_concept_id")
    private Integer raceSourceConceptId;

    @Column(name = "ethnicity_source_value")
    private String ethnicitySourceValue;

    @Column(name = "ethnicity_source_concept_id")
    private Integer ethnicitySourceConceptId;

    // Getters and Setters

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getGenderConceptId() {
        return genderConceptId;
    }

    public void setGenderConceptId(Integer genderConceptId) {
        this.genderConceptId = genderConceptId;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public Integer getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getRaceConceptId() {
        return raceConceptId;
    }

    public void setRaceConceptId(Integer raceConceptId) {
        this.raceConceptId = raceConceptId;
    }

    public Integer getEthnicityConceptId() {
        return ethnicityConceptId;
    }

    public void setEthnicityConceptId(Integer ethnicityConceptId) {
        this.ethnicityConceptId = ethnicityConceptId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getCareSiteId() {
        return careSiteId;
    }

    public void setCareSiteId(Integer careSiteId) {
        this.careSiteId = careSiteId;
    }

    public String getPersonSourceValue() {
        return personSourceValue;
    }

    public void setPersonSourceValue(String personSourceValue) {
        this.personSourceValue = personSourceValue;
    }

    public String getGenderSourceValue() {
        return genderSourceValue;
    }

    public void setGenderSourceValue(String genderSourceValue) {
        this.genderSourceValue = genderSourceValue;
    }

    public Integer getGenderSourceConceptId() {
        return genderSourceConceptId;
    }

    public void setGenderSourceConceptId(Integer genderSourceConceptId) {
        this.genderSourceConceptId = genderSourceConceptId;
    }

    public String getRaceSourceValue() {
        return raceSourceValue;
    }

    public void setRaceSourceValue(String raceSourceValue) {
        this.raceSourceValue = raceSourceValue;
    }

    public Integer getRaceSourceConceptId() {
        return raceSourceConceptId;
    }

    public void setRaceSourceConceptId(Integer raceSourceConceptId) {
        this.raceSourceConceptId = raceSourceConceptId;
    }

    public String getEthnicitySourceValue() {
        return ethnicitySourceValue;
    }

    public void setEthnicitySourceValue(String ethnicitySourceValue) {
        this.ethnicitySourceValue = ethnicitySourceValue;
    }

    public Integer getEthnicitySourceConceptId() {
        return ethnicitySourceConceptId;
    }

    public void setEthnicitySourceConceptId(Integer ethnicitySourceConceptId) {
        this.ethnicitySourceConceptId = ethnicitySourceConceptId;
    }
}
