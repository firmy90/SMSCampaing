package com.marketing.smscampaing.validation.validators;

import com.marketing.smscampaing.dtos.ChangePasswordDTO;
import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.validation.constraints.ChangeSamePasswords;
import com.marketing.smscampaing.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChangeSamePasswordValidator implements ConstraintValidator<ChangeSamePasswords, ChangePasswordDTO> {
    @Override
    public void initialize(ChangeSamePasswords constraintAnnotation) {

    }

    @Override
    public boolean isValid(ChangePasswordDTO changePasswordDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (changePasswordDTO.getPassword() == null || changePasswordDTO.getRePassword() == null) {
            return true;
        }
        boolean valid =  changePasswordDTO.getRePassword().equals(changePasswordDTO.getPassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
//            constraintValidatorContext.buildConstraintViolationWithTemplate("Hasła nie zgadzają się")
            constraintValidatorContext.buildConstraintViolationWithTemplate("ChangeSamePasswords.passwordData.rePassword")
                    .addPropertyNode("rePassword").addConstraintViolation();
        }
        return valid;

    }
}
