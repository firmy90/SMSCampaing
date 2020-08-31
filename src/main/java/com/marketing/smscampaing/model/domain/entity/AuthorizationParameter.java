package com.marketing.smscampaing.model.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorization_parameters")
@Getter @Setter @ToString(callSuper = true, exclude = {"apiKey"})
public class AuthorizationParameter extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String provider;
    @Column(nullable = false)
    private String apiKey;
    @Column(nullable = false)
    private String url;
    private boolean active = true;

}
