package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.validation.constraints.SamePasswords;
import com.marketing.smscampaing.validation.constraints.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@SamePasswords
public class RegistrationDTO {
    @NotBlank
    @Size(min = 4, max = 100)
    @UniqueUsername
    private String username;
    @NotBlank
    @Size(min = 4, max = 100)
    private String name;
    @NotBlank
    @Size(min = 4, max = 100)
    private String surname;
    @NotBlank
//    @Size(min = 6, max = 100, message = "{javax.validation.constraints.Size.message.minPassword}")
    @Size(min = 6, message = "{javax.validation.constraints.Size.message.minPassword}")
    @Size(max=100, message = "{javax.validation.constraints.Size.message.maxPassword}")
    private String password;
    @NotBlank
    @Size(min = 6, message = "{javax.validation.constraints.Size.message.minPassword}")
    @Size(max=100, message = "{javax.validation.constraints.Size.message.maxPassword}")
    private String rePassword;

}
