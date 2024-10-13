package com.wanted.controller;

import com.wanted.common.url.Urls;
import com.wanted.services.serviceapi.MoneyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Tag(name = "Money", description = "Методы для взаимодействия c денежными суммами")
public class MoneyController {

    private final MoneyService moneyService;

    @Operation(summary = "метода принимает денежную сумму номиналом до 99 999.99 и возвращает ее прописное значение")
    @GetMapping(Urls.Money.StringValue.FULL)
    public String getDateForSendingList(@PathVariable BigDecimal number) {
        return moneyService.getStringValue(number);
    }
}
