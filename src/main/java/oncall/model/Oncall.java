package oncall.model;

public class Oncall {
    private final Workers weekdayWorkers;
    private final Workers holidayWorkers;
    private Worker lastWeekdayWorker;
    private Worker lastHolidayWorker;

    public Oncall(Workers weekdayWorkers, Workers holidayWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public Worker getNextHolidayWorker() {
        return null;
    }

    public Worker getNextWeekdayWorker() {
        return null;
    }
}
