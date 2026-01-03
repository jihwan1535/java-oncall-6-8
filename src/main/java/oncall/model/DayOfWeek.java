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

    private static DayOfWeek findDayOfWeekBySequence(int sequence) {
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.sequence == sequence)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public String determineDayOfWeek(int day) {
        int sequence = (this.sequence + day - 1) % 7;
        return findDayOfWeekBySequence(sequence).dayOfWeek;
    }

    public boolean isWeekDay(int day) {
        int sequence = (this.sequence + day - 1) % 7;
        DayOfWeek dayOfWeek = findDayOfWeekBySequence(sequence);
        return dayOfWeek != SAT && dayOfWeek != SUN;
    }
}
