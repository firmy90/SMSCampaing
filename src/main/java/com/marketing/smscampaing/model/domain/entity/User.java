package com.marketing.smscampaing.model.domain.entity;

import com.marketing.smscampaing.model.domain.entity.enums.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter @ToString @EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Size(max=100)
    @Column(length = 100)
    @OrderColumn
    private String username;
    @Size(max=100)
    @Column(length=100)
    private String name;
    @Size(max=100)
    @Column(length=100)
    private String surname;
    @Size(max=100)
    @Column(length=100)
    private String password;

    @DateTimeFormat
    private LocalDateTime created;
    @DateTimeFormat
    private LocalDateTime updated;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean visible = Boolean.TRUE;


    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }



}
