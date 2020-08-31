package com.marketing.smscampaing.model.domain.entity;

import com.marketing.smscampaing.model.domain.entity.enums.DeliveredStatusMessage;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="campaing_messages")
public class CampaingMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="campaing_id")
    private Campaing campaing;
    @Column(name="campaing_id", updatable = false, insertable = false)
    private Long campaingId;

    @ManyToOne
    @JoinColumn(name="phone_id")
    private Phone phone;
    @Column(name="phone_id",  updatable = false, insertable = false)
    private Long phoneId;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(name="client_id", updatable = false, insertable = false)
    private Long clientId;

    @Column(name = "content", columnDefinition = "TEXT")
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name="authorization_id")
    private AuthorizationParameter authorization;
//    @Column(name="authorization_id")
    @Column(name="authorization_id",updatable = false, insertable = false)
    private Long authorizationId;


    @Column(name = "generated_links", length = 50)
    @Max(50)
    private String generatedLinks;

    @DateTimeFormat
    @Column(name = "sending_date")
    private LocalDateTime sendingDate;

    private boolean sendingStatus = Boolean.TRUE;
    @Enumerated(EnumType.STRING)
    private DeliveredStatusMessage deliveredStatusMessage = DeliveredStatusMessage.UNKNOWN;


}
