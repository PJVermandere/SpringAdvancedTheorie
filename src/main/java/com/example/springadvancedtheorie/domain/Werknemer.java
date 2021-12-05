package com.example.springadvancedtheorie.domain;

import javax.persistence.*;

@Entity
@Table(name = "werknemers")
public class Werknemer {
    @Id
    private long id;
    private String voornaam, achternaam;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "filiaalId")
    private Filiaal filiaal;

    protected Werknemer() {
    }

    public Werknemer(String voornaam, String achternaam, Filiaal filiaal) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.filiaal = filiaal;
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Filiaal getFiliaal() {
        return filiaal;
    }
}
