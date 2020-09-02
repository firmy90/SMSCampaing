package com.marketing.smscampaing.validation.validators;

import com.marketing.smscampaing.model.domain.entity.enums.GenderEnum;
import com.marketing.smscampaing.services.interfaces.ValidationService;
import com.marketing.smscampaing.validation.constraints.CorrectGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
@Getter
@Setter
public class CorrectGenderValidator implements ConstraintValidator<CorrectGender, String> {
    private final ValidationService validationService;

    @Override
    public void initialize(CorrectGender constraintAnnotation) {

    }

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext constraintValidatorContext) {
        if (gender == null) {
            return true;
        }
        for (GenderEnum value : GenderEnum.values()) {
            if (gender.equals(value.toString())) {
                return true;
            }
        }
        return false;
    }
}
