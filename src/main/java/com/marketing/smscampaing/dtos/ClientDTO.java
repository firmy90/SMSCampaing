package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.validation.constraints.DateFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ClientDTO {
    @Size(min = 3, message = "{javax.validation.constraints.Size.message.min3}")
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    @NotNull
    private String name;
    @NotNull
    @Size(min = 3, message = "{javax.validation.constraints.Size.message.min3}")
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String surname;

    @NotNull
    @DateFormat(message = "{DateFormat.clientData.birthdate}")
    private String birthdate;

//    @NotNull
    private String occupationOccupation;

//    @NotNull
    private String genderGender;

}