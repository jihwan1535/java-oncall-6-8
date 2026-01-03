package oncall.model;

import java.util.Arrays;

public enum Holiday {
    NEW_YEAR(Month.JAN, 1),
    MARCH_FIRST(Month.MAR, 1),
    DAY_OF_CHILDREN(Month.MAY, 5),
    MEMORIAL(Month.JUN, 6),
    LIBERATION(Month.AUG, 15),
    NATIONAL_FOUNDATION(Month.OCT, 3),
    KOREAN_ALPHABET(Month.OCT, 9),
    CHRISTMAS(Month.DEC, 25),
    NONE(null, 0);

    private final Month month;
    private final int day;

    Holiday(Month month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean exsist(Month month, int day) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.month == month && holiday.day == day);
    }
}
