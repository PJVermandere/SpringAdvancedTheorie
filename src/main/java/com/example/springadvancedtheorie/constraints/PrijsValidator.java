package com.example.springadvancedtheorie.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class PrijsValidator implements ConstraintValidator<Prijs, BigDecimal> {
    @Override
    public void initialize(Prijs constraintAnnotation){};
    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context){
        if(value == null) return true;
        if (value.compareTo(BigDecimal.ZERO) < 0 || value.scale() > 2) return false;
        return value.precision() - value.scale() <= 7;
    }
}
