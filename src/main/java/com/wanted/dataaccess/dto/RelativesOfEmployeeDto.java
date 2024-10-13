package com.wanted.dataaccess.dto;

import com.wanted.dataaccess.entity.HPPersonDependant;
import com.wanted.dataaccess.entity.HPPersonGeneric;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RelativesOfEmployeeDto {

    @Schema(description = "Собственное имя")
    private String givenName;

    @Schema(description = "Отчество")
    private String middleName;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Фамилия")
    private String familyName;

    @Schema(description = "Дата рождения")
    private LocalDate birthDate;

    @Schema(description = "Родственная связь")
    private String contactRelationship;

    public RelativesOfEmployeeDto(HPPersonDependant hpPersonDependant, HPPersonGeneric hpRelatedPersonSysId){
        this.givenName = hpRelatedPersonSysId.getGivenName();
        this.middleName = hpRelatedPersonSysId.getMiddleName();
        this.name = hpRelatedPersonSysId.getName();
        this.familyName = hpRelatedPersonSysId.getFamilyName();
        this.birthDate = hpRelatedPersonSysId.getBirthDate().toLocalDate();
        this.contactRelationship = hpPersonDependant.getContactRelationship();
    }
}
