package Entities;

import java.time.LocalDate;

public class Gamer {

    private int id;
    private String name;
    private String surName;
    private String nationalityId;
    private LocalDate birthDate;

    public Gamer(int id, String name, String surName, String nationalityId, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.nationalityId = nationalityId;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
