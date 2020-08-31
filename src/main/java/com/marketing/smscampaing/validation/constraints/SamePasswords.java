package com.marketing.smscampaing.validation.constraints;

import com.marketing.smscampaing.validation.validators.SamePasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = SamePasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswords {
    String message() default "passwords do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

