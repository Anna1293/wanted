package com.wanted.services.servicedimpl;

import com.wanted.services.serviceapi.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private static final int FIRST_DAY_OF_THE_MONTH = 1;
    private static final int TENTH_DAY_OF_THE_MONTH = 10;
    private static final int TWENTIETH_DAY_OF_THE_MONTH = 20;
    private static final int END_OF_THE_WORKING_DAY = 18;
    private static final int ONE_DAY = 1;
    private static final int TWO_DAY = 2;

    @Override
    public String getDateForSendingList() {
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        int currentDate = checkCurrentHour(currentDateTime);
        int sendingListDay = checkDayOfMonth(currentDate);
        LocalDate resultDate = validateSendingListDay(sendingListDay);
        return resultDate.toString();
    }

    private int checkCurrentHour(OffsetDateTime currentDateTime) {
        int hour = currentDateTime.getHour();
        if (hour >= END_OF_THE_WORKING_DAY) {
            OffsetDateTime currentDateTimePlusOneDay = currentDateTime.plusDays(ONE_DAY);
            return currentDateTimePlusOneDay.getDayOfMonth();
        }
        return currentDateTime.getDayOfMonth();
    }

    private int checkDayOfMonth(int currentDate) {
        if (currentDate > TWENTIETH_DAY_OF_THE_MONTH || currentDate == FIRST_DAY_OF_THE_MONTH) {
            return FIRST_DAY_OF_THE_MONTH;
        } else if (currentDate > FIRST_DAY_OF_THE_MONTH && currentDate <= TENTH_DAY_OF_THE_MONTH) {
            return TENTH_DAY_OF_THE_MONTH;
        } else {
            return TWENTIETH_DAY_OF_THE_MONTH;
        }
    }

    private LocalDate validateSendingListDay(int sendingListDay) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime specificDate = now.withDayOfMonth(sendingListDay);
        if(specificDate.getDayOfWeek().getValue() == DayOfWeek.SATURDAY.getValue()){
            return specificDate.minusDays(ONE_DAY).toLocalDate();
        } else if (specificDate.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue()) {
            return specificDate.minusDays(TWO_DAY).toLocalDate();
        } else {
            return specificDate.toLocalDate();
        }
    }
}
