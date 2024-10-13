package com.wanted.controller;

import com.wanted.common.url.Urls;
import com.wanted.dataaccess.dto.RelativesOfEmployeeDto;
import com.wanted.services.serviceapi.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Employee", description = "Методы для взаимодействия c сотрудниками компании")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Метод возвращает всех родственников работника по полю personId")
    @GetMapping(Urls.Employee.Relatives.FULL)
    public List<RelativesOfEmployeeDto> getAllRelativesByPersonId(@PathVariable String personId){
        return employeeService.getAllRelativesByPersonId(personId);
    }
}
