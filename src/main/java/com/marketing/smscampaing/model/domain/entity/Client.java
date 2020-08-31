package com.marketing.smscampaing.model.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString @EqualsAndHashCode(of="uid")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long uid;
    @Size(max=100)
    @Column(length = 100)
    @OrderColumn
    private String name;
    @Size(max=100)
    @Column(length=100)
    private String surname;
    @DateTimeFormat
    private LocalDate birthdate;


    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;
    @Column(name = "gender_id", insertable = false, updatable = false)
    private Long genderId;

    @DateTimeFormat
    private LocalDateTime created;
    @DateTimeFormat
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name="occupation_id")
    private Occupation occupation;
    @Column(name = "occupation_id", insertable = false, updatable = false)
    private Long occupationId;
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
