package com.marketing.smscampaing.model.domain.entity;

import com.marketing.smscampaing.model.domain.entity.enums.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true, exclude = {"password"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {


    @Size(max = 100)
    @Column(length = 100)
    @OrderColumn
    private String username;
    @Size(max = 100)
    @Column(length = 100)
    private String name;
    @Size(max = 100)
    @Column(length = 100)
    private String surname;
    @Size(max = 100)
    @Column(length = 100)
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean visible = Boolean.TRUE;


}
