package com.example.springadvancedtheorie.domain;

import com.example.springadvancedtheorie.constraints.Prijs;
import com.example.springadvancedtheorie.constraints.PrijzenValidator;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@PrijzenValidator
public class Product {
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;

    public void setAankoopprijs(BigDecimal aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public void setVerkoopprijs(BigDecimal verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    public BigDecimal getAankoopprijs() {
        return aankoopprijs;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }
}
