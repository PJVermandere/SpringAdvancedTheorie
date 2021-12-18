package com.example.springadvancedtheorie.constraints;

import com.example.springadvancedtheorie.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<PrijzenValidator, Product> {
    @Override
    public void initialize(PrijzenValidator constraintValidator){};
    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context){
        if(product == null) return true;
        if(product.getVerkoopprijs() == null || product.getAankoopprijs() == null) return false;
        return product.getAankoopprijs().compareTo(product.getVerkoopprijs()) <= 0;
    }
}
