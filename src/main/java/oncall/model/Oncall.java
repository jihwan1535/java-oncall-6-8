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
        Worker nextWorker = holidayWorkers.getNextWorker(lastHolidayWorker);
        if (nextWorker.equals(lastWeekdayWorker)) {
            holidayWorkers.swapNext(nextWorker);
            nextWorker = holidayWorkers.getNextWorker(lastHolidayWorker);
        }

        lastHolidayWorker = nextWorker;
        return nextWorker;
    }

    public Worker getNextWeekdayWorker() {
        Worker nextWorker = weekdayWorkers.getNextWorker(lastWeekdayWorker);
        if (nextWorker.equals(lastHolidayWorker)) {
            weekdayWorkers.swapNext(nextWorker);
            nextWorker = weekdayWorkers.getNextWorker(lastHolidayWorker);
        }

        lastWeekdayWorker = nextWorker;
        return nextWorker;
    }
}
