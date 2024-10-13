package com.wanted.dataaccess.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "hp_person_generic")
@Getter
public class HPPersonGeneric {

    @Id
    @Column(name = "sys_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sysId;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "sys_version")
    private Long sysVersion;

    @Column(name = "photo_fk_sys_id")
    private Long photoFkSysId;

    @Column(name = "sys_extension")
    private String sysExtension;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "name")
    private String name;

    @Column(name = "name_translation_sys_id")
    private Long nameTranslationSysId;

    @Column(name = "alt_family_name")
    private String altFamilyName;

    @Column(name = "alt_given_name")
    private String altGivenName;

    @Column(name = "alt_middle_name")
    private String altMiddleName;

    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "primary_language")
    private String primaryLanguage;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "residence")
    private String residence;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "religion")
    private String religion;

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
    @OneToMany(mappedBy = "hpPersonGenericSysId", fetch = FetchType.LAZY)
    private List<HPPersonDependant> personDependants;


    @ToString.Exclude
    @OneToOne(
            mappedBy = "hpRelatedPersonSysId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private HPPersonDependant hpPersonDependant;
}
