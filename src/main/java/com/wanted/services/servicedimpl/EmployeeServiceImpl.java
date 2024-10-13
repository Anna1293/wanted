package com.wanted.services.servicedimpl;

import com.wanted.dataaccess.dto.RelativesOfEmployeeDto;
import com.wanted.dataaccess.entity.HPPersonGeneric;
import com.wanted.dataaccess.repository.HPPersonGenericRepository;
import com.wanted.services.serviceapi.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final HPPersonGenericRepository hpPersonGenericRepository;

    @Override
    public List<RelativesOfEmployeeDto> getAllRelativesByPersonId(String personId) {
        HPPersonGeneric personGeneric = hpPersonGenericRepository.getByPersonId(personId);
        return personGeneric.getPersonDependants().stream()
                .map(hpPersonDependant ->
                        new RelativesOfEmployeeDto(hpPersonDependant, hpPersonDependant.getHpRelatedPersonSysId()))
                .toList();
    }
}
