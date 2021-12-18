package com.example.springadvancedtheorie.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {PrijsValidator.class})
public @interface Prijs {
    String message() default "{com.example.springadvancedtheorie.messages}";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
