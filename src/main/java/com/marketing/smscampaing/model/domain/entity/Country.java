package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="countries")
public class Country extends BaseEntity {

    @Column(nullable = false)
    @Size(max=100)
    private String name;

}
