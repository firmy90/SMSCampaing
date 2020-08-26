package com.marketing.smscampaing.model.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString @EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Size(max=100)
    @Column(length = 100)
    @OrderColumn
    private String name;
    @Size(max=100)
    @Column(length=100)
    private String surname;
    @DateTimeFormat
    private LocalDate birthdate;

//    @Enumerated(EnumType.STRING)
//    @NotNull
//    private ClientGender gender = ClientGender.UNKNOWN;
    @ManyToOne
    @JoinColumn(name="gender_id")
    private ClientGender gender;
    @Column(name = "gender_id", insertable = false, updatable = false)
    private Long genderId;

    @DateTimeFormat
    private LocalDateTime created;
    @DateTimeFormat
    private LocalDateTime updated;
    @ManyToOne
    private Occupation occupation;
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
