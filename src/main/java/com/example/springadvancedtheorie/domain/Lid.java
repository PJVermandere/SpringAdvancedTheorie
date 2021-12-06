package com.example.springadvancedtheorie.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "leden")
public class Lid {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String voornaam,familienaam;
    @Email
    private String email;
    @DateTimeFormat(style = "S-")
    private LocalDate lidSinds;

    protected Lid() {
    }

    public Lid(String voornaam, String familienaam, String email) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
        this.lidSinds = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getLidSinds() {
        return lidSinds;
    }
}
