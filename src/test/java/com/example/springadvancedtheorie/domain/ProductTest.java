package com.example.springadvancedtheorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Validator validator;
    private Product product;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        product = new Product();
        product.setAankoopprijs(BigDecimal.ONE);
        product.setVerkoopprijs(BigDecimal.TEN);
    }

    @Test
    void juisteWaarden(){
        assertThat(validator.validate(product)).isEmpty();
    }
    @ParameterizedTest @ValueSource(strings = {"-1", "1.232","456845321"})
    void fouteAankoopWaarden(String prijs){
        product.setAankoopprijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }
    @ParameterizedTest @ValueSource(strings = {"-1", "1.232","456845321"})
    void fouteVerkoopWaarden(String prijs){
        product.setVerkoopprijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }
    @Test
    void aankoopGroterDanVerkoopprijs(){
        product.setVerkoopprijs(BigDecimal.ONE);
        product.setAankoopprijs(BigDecimal.TEN);
        assertThat(validator.validate(product)).isNotEmpty();
    }
}