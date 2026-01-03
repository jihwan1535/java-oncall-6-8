package oncall.model;

public record Schedule(Month month, DayOfWeek dayOfWeek, Oncall oncall) {

    public String getMonth() {
        return month.month();
    }

    public int getLastDay() {
        return month.lastDay();
    }

    public String getDayOfWeek(int day) {
        return dayOfWeek.determineDayOfWeek(day);
    }

    public boolean isWeekHoliday(int day) {
        return dayOfWeek.isWeekDay(day) && Holiday.exsist(month, day);
    }
}
