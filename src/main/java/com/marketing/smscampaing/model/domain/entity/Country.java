package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(max=100)
    private String name;

}
