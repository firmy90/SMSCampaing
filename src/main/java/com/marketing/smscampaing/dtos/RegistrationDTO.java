package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.validation.constraints.SamePasswords;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@SamePasswords
public class RegistrationDTO {
    @NotBlank
    @Size(min = 4, max = 100)
    private String username;
    @NotBlank
    @Size(min = 4, max = 100)
    private String name;
    @NotBlank
    @Size(min = 4, max = 100)
    private String surname;
    @NotBlank
    @Size(min = 4, max = 12)
    private String password;
    @NotBlank
    @Size(min = 4, max = 12)
    private String rePassword;

}
