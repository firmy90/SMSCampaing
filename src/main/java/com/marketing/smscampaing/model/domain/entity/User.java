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


    @Column(length = 100,unique = true, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String surname;

    @Column(length = 100, nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean visible = Boolean.TRUE;


}
