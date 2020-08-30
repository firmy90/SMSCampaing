package com.marketing.smscampaing.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="campaing_messages")
public class CampaingMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="campaing_id", insertable = false, updatable = false)
    private Campaing campaing;
    @Column(name="campaing_id", insertable = false, updatable = false)
    private Long campaingId;

    @ManyToOne
    @JoinColumn(name="phone_id")
    private Phone phone;
    @Column(name="phone_id", insertable = false, updatable = false)
    private Long phoneId;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(name="client_id", insertable = false, updatable = false)
    private Long clientId;


    @Column(name = "content", columnDefinition = "TEXT")
    @NotNull
    @Max(500)
    @Min(1)
    private String content;

    @ManyToOne
    @JoinColumn(name="authorization_id")
    private AuthorizationParameter authorization;
    @Column(name="authorization_id", insertable = false, updatable = false)
    private Long authorizationId;


    @Column(name = "generated_links", length = 50)
    @Max(50)
    private String generatedLinks;


}
