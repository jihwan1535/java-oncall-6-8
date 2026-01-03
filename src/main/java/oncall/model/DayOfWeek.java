package oncall.model;

import java.util.Arrays;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;

public enum DayOfWeek {

    SUN("일", 0),
    MON("월", 1),
    TUE("화", 2),
    WED("수", 3),
    THU("목", 4),
    FRI("금", 5),
    SAT("토", 6);

    private final String dayOfWeek;
    private final int sequence;

    DayOfWeek(String dayOfWeek, int sequence) {
        this.dayOfWeek = dayOfWeek;
        this.sequence = sequence;
    }

    public static DayOfWeek from(String dayOfWeek) {
        return Arrays.stream(values())
                .filter(value -> value.dayOfWeek.equals(dayOfWeek))
                .findFirst()
                .orElseThrow(() -> new CustomException(ExceptionMessage.INVALID_INPUT));
    }
}
