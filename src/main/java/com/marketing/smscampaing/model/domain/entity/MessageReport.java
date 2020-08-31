package com.marketing.smscampaing.model.domain.entity;

import com.marketing.smscampaing.model.domain.entity.enums.DeliveredStatusMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "messages_reports")
@Getter @Setter @ToString(callSuper = true)
public class MessageReport extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "message_campaing_id")
    private CampaingMessage campaingMessage;
    @Column(name="message_campaing_id",insertable = false, updatable = false)
    private Long campaingMessageId;


    @Column(name = "sending_date")
    private LocalDate sendingDate;
    private boolean sendingStatus = Boolean.TRUE;
    @Enumerated(EnumType.STRING)
    private DeliveredStatusMessage deliveredStatusMessage = DeliveredStatusMessage.UNKNOWN;

    @Column(name = "clicked_link")
    private LocalDate clickedLink;


}
