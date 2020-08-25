package com.marketing.smscampaing.model.domain.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @ToString @EqualsAndHashCode(of="id")
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="campaings")
public class Campaing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "campaing_name")
    private String campaignName;
    @Column(name="starting_date")
    private LocalDate startingDate;
    @Column(name="finish_date")
    private LocalDate finishDate;
    private boolean visible = Boolean.TRUE;



}
