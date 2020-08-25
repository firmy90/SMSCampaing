package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String occupation;


}
