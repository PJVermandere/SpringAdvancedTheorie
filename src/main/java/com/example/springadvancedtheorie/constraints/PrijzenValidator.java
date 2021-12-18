package com.example.springadvancedtheorie.constraints;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = ProductValidator.class)
public @interface PrijzenValidator{
    String message() default"{com.example.springadvanced.messages}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
