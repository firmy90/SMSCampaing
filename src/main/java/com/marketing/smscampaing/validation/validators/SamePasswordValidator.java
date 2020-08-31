package com.marketing.smscampaing.validation.validators;

import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidator implements ConstraintValidator<SamePasswords, RegistrationDTO> {
    @Override
    public void initialize(SamePasswords constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegistrationDTO registrationDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (registrationDTO.getPassword() == null || registrationDTO.getRePassword() == null) {
            return true;
        }
        boolean valid =  registrationDTO.getRePassword().equals(registrationDTO.getPassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
//            constraintValidatorContext.buildConstraintViolationWithTemplate("Hasła nie zgadzają się")
            constraintValidatorContext.buildConstraintViolationWithTemplate("SamePasswords.registrationData.rePassword")
                    .addPropertyNode("rePassword").addConstraintViolation();
        }
        return valid;

    }
}
