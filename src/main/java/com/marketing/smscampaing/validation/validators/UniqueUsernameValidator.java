package com.marketing.smscampaing.validation.validators;

import com.marketing.smscampaing.services.ValidationService;
import com.marketing.smscampaing.validation.constraints.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor @Getter @Setter
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final ValidationService validationService;
    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return validationService.isUniqueUsername(username);
    }
}
