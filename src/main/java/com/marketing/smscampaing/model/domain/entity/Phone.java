package com.marketing.smscampaing.model.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phones")
public class Phone extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="number", nullable = false, length = 15)
    private String number;

    @ManyToOne
    @JoinColumn(name="purpose_id")
    private Purpose purpose;
    @Column(name = "purpose_id", insertable = false, updatable = false)
    private Long purposeId;

    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;
    @Column(name = "type_id", insertable = false, updatable = false)
    private Long typeId;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long countryId;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(name="client_id", insertable = false, updatable = false)
    private Long clientId;

    private boolean visible = Boolean.TRUE;


}
