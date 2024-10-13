package com.wanted.services.serviceapi;

import com.wanted.dataaccess.dto.RelativesOfEmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<RelativesOfEmployeeDto> getAllRelativesByPersonId(String personId);
}
