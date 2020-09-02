package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.validation.constraints.CorrectGender;
import com.marketing.smscampaing.validation.constraints.DateFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ClientDTO {
    @Size(min = 3, message = "{javax.validation.constraints.Size.message.min3}")
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    @NotNull
    @Pattern(regexp = "^[A-Ża-ż]+$")
    private String name;
    @NotNull
    @Size(min = 3, message = "{javax.validation.constraints.Size.message.min3}")
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    @Pattern(regexp = "^[A-Ża-ż\\-]+$")
    private String surname;

    @NotNull
    @DateFormat(message = "{DateFormat.clientData.birthdate}")
    private String birthdate;

//    @NotNull
    private String occupationOccupation;

//    @NotNull
    @CorrectGender
    private String genderGender;
    private int code;

}
