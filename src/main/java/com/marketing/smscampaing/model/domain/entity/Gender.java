package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter @ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="genders")
public class Gender extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String gender;
}
