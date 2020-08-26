package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter @ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="genders")
public class ClientGender {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Size(max=100)
    private String gender;
}