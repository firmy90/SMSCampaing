package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.validation.constraints.ChangeSamePasswords;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
@ChangeSamePasswords
public class ChangePasswordDTO {

    private String username;
    private String name;
    private String surname;
    @NotBlank
    @Size(min = 6, message = "{javax.validation.constraints.Size.message.minPassword}")
    @Size(max=100, message = "{javax.validation.constraints.Size.message.maxPassword}")
    // TODO Dlaczego wystawiamy na zewnątrz hasło?
    private String password;
    @NotBlank
    @Size(min = 6, message = "{javax.validation.constraints.Size.message.minPassword}")
    @Size(max=100, message = "{javax.validation.constraints.Size.message.maxPassword}")
    private String rePassword;
    private int code;

}
