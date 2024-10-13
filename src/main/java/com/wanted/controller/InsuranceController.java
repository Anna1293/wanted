package com.wanted.controller;

import com.wanted.common.url.Urls;
import com.wanted.services.serviceapi.InsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Insurance", description = "Методы для взаимодействия со страховой компанией")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @Operation(summary = "метода определяет ближайшую дату отправки списка в страховую с условием, что отправка " +
            "осуществляется 1, 10 и 20 числа каждого месяца в 18:00. Если дата отправки попадает на рабочий/праздничный " +
            "день - то отправка осуществляется в предыдущий рабочий день")
    @GetMapping(Urls.Insurance.SendingList.FULL)
    public String getDateForSendingList() {
        return insuranceService.getDateForSendingList();
    }
}
