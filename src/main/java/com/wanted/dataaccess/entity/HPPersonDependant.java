package com.wanted.dataaccess.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.OffsetDateTime;

@Entity
@Table(name = "hp_person_dependant")
@Getter
public class HPPersonDependant {
    @Id
    @Column(name = "sys_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sysId;

    @Column(name = "sys_version")
    private Long sysVersion;

    @Column(name = "attachment_fk_sys_id")
    private Long attachmentFkSysid;

    @Column(name = "contact_relationship")
    private String contactRelationship;

    @Column(name = "id")
    private Long id;

    @Column(name = "sys_tenant")
    private String sysTenant;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "creation_time")
    private OffsetDateTime creationTime;

    @Column(name = "sys_change_user")
    private String sysChangeUser;

    @UpdateTimestamp
    @Column(name = "sys_change_time")
    private String sysChangeTime;

    @Column(name = "sys_parent_id")
    private Long sysParentId;

    @Column(name = "sys_date_to")
    private OffsetDateTime sysDateTo;

    @Column(name = "sys_date_from")
    private OffsetDateTime sysDateFrom;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hp_person_generic_sys_id")
    private HPPersonGeneric hpPersonGenericSysId;


    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hp_related_person_sys_id")
    private HPPersonGeneric hpRelatedPersonSysId;
}