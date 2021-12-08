package com.example.springadvancedtheorie.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Entity
@Table(name = "filialen")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filiaal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String naam, gemeente;
    @NotNull
    private BigDecimal omzet;

    protected Filiaal() {
    }

    public Filiaal(String naam, String gemeente, BigDecimal omzet) {
        this.naam = naam;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public BigDecimal getOmzet() {
        return omzet;
    }

    public Filiaal withId(long id){
        var filiaal = new Filiaal(naam, gemeente, omzet);
        filiaal.id = id;
        return filiaal;
    }
}
