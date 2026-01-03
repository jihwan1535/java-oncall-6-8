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
        return dayOfWeek.isWeekday(day) && Holiday.exsist(month, day);
    }

    public Worker getNextWorker(int day) {
        if (dayOfWeek.isWeekend(day) || Holiday.exsist(month, day)) {
            return oncall.getNextHolidayWorker();
        }
        return oncall.getNextWeekdayWorker();
    }
}
