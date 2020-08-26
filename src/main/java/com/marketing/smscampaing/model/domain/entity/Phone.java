package com.marketing.smscampaing.model.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="number", nullable = false)
    @Size(max=15)
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

    @DateTimeFormat
    private LocalDate created;
    @DateTimeFormat
    private LocalDate updated;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(name="client_id", insertable = false, updatable = false)
    private Long clientId;

    private boolean visible = Boolean.TRUE;

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
        this.updated = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDate.now();
    }
}
