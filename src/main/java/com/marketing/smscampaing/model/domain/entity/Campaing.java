package com.marketing.smscampaing.model.domain.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaings")
public class Campaing extends BaseEntity {

    @Column(name = "campaing_name")
    private String cname;
    @Column(name = "starting_date")
    private LocalDate startingDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
    private boolean visible = Boolean.TRUE;


}
