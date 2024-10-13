package com.wanted.services.servicedimpl;

import com.wanted.services.serviceapi.MoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.wanted.common.constants.NumberStringArray.hundreds;
import static com.wanted.common.constants.NumberStringArray.tenThousands;
import static com.wanted.common.constants.NumberStringArray.tens;
import static com.wanted.common.constants.NumberStringArray.thousands;
import static com.wanted.common.constants.NumberStringArray.units;
import static com.wanted.common.constants.RubleStringArray.rubles;

@Service
@RequiredArgsConstructor
public class MoneyServiceImpl implements MoneyService {

    private static final int ROUNDING_DEGREE = 2;

    @Override
    public String getStringValue(BigDecimal number) {
        validate(number);
        return convertBigDecimalToString(number);
    }

    private String convertBigDecimalToString(BigDecimal number) {
        number = number.setScale(ROUNDING_DEGREE, RoundingMode.HALF_UP);
        BigDecimal[] parts = number.divideAndRemainder(BigDecimal.ONE);
        int wholePart = parts[0].intValue();
        int fractionalPart = parts[1].movePointRight(2).intValue();
        String wholePartInWords = convertWholePart(wholePart);
        String fractionalPartInWords = convertFractionalPart(fractionalPart);
        return wholePartInWords + (fractionalPart > 0 ? " и " + fractionalPartInWords : "");
    }

    private static void validate(BigDecimal number) {
        if (number == null || number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной.");
        }
    }

    private String convertWholePart(int number) {
        if (number == 0) return "ноль рублей";
        StringBuilder result = new StringBuilder();
        if (number >= 10000) {
            result.append(tenThousands[number / 10000]).append(" ");
            number %= 10000;
        }
        if (number >= 1000) {
            result.append(thousands[number / 1000]).append(" ");
            number %= 1000;
        }
        if (number >= 100) {
            result.append(hundreds[number / 100]).append(" ");
            number %= 100;
        }
        if (number >= 20) {
            result.append(tens[number / 10]).append(" ");
            number %= 10;
        }
        if (number > 0) {
            result.append(units[number]).append(" ");
        }
        result.append(getRublesDeclension(number));
        return result.toString().trim();
    }

    private String getRublesDeclension(int number) {
        int lastDigit = number % 10;
        int lastTwoDigits = number % 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return rubles[2];
        } else if (lastDigit == 1) {
            return rubles[0];
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return rubles[1];
        } else {
            return rubles[2];
        }
    }

    private String convertFractionalPart(int number) {
        if (number == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        if (number >= 20) {
            result.append(tens[number / 10]).append(" ");
            number %= 10;
        }
        if (number > 1 && number < 20) {
            result.append(units[number]);
        }
        if (number == 1) {
            result.append(units[20]);
        }
        result.append(number == 1 ? " копейка" : (number < 5 ? " копейки" : " копеек"));
        return result.toString();
    }
}
