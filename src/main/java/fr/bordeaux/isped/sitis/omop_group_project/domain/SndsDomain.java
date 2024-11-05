package fr.bordeaux.isped.sitis.omop_group_project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tab_patient", schema = "synthetic_snds")
public class SndsDomain {
    @Id
    @Column(name = "pat_id")
    private String patId;
    @Column(name = "pat_sex_cod")
    private Integer patSexCod;
    @Column(name = "pat_birth_date")
    private LocalDate patBirthDate;
    @Column(name = "pat_dpt_res")
    private Integer patDptRes;

    //Constructors

    public SndsDomain() {
    }


    //Getters and Setters
    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public Integer getPatSexCod() {
        return patSexCod;
    }

    public void setPatSexCod(Integer patSexCod) {
        this.patSexCod = patSexCod;
    }

    public LocalDate getPatBirthDate() {
        return patBirthDate;
    }

    public void setPatBirthDate(LocalDate patBirthDate) {
        this.patBirthDate = patBirthDate;
    }

    public Integer getPatDptRes() {
        return patDptRes;
    }

    public void setPatDptRes(Integer patDptRes) {
        this.patDptRes = patDptRes;
    }
}
