package oncall.model;

import java.util.Arrays;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;

public enum Month {

    JAN("1", 31),
    FEB("2", 28),
    MAR("3", 31),
    APR("4", 30),
    MAY("5", 31),
    JUN("6", 30),
    JUL("7", 31),
    AUG("8", 31),
    SEP("9", 30),
    OCT("10", 31),
    NOV("11", 30),
    DEC("12", 31);

    private final String month;
    private final int lastDay;

    Month(String month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static Month from(String month) {
        return Arrays.stream(values())
                .filter(value -> value.month.equals(month))
                .findFirst()
                .orElseThrow(() -> new CustomException(ExceptionMessage.INVALID_INPUT));
    }

    public String month() {
        return month;
    }

    public int lastDay() {
        return lastDay;
    }
}
