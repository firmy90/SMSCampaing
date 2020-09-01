package com.marketing.smscampaing.validation.validators;

import com.marketing.smscampaing.validation.constraints.DateFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import static org.apache.tomcat.jni.Time.now;

@AllArgsConstructor
@Getter
@Setter
public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {
    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                    + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

    @Override
    public void initialize(DateFormat constraintAnnotation) {

    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null){
            return true;
        }
        if (DATE_PATTERN.matcher(s).matches()) {
            LocalDate date = LocalDate.parse(s);
            return date.isBefore(LocalDate.now());
        }
        return false;
    }
}
