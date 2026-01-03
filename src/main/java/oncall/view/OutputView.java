package oncall.view;

import oncall.model.Schedule;
import oncall.model.Worker;

public class OutputView {

    private static void printScheduleByDay(Schedule schedule, int day, String nextWorker) {
        if (schedule.isWeekHoliday(day)) {
            System.out.printf("%s월 %d일 %s(휴일) %s%n",
                    schedule.getMonth(), day, schedule.getDayOfWeek(day), nextWorker);
            return;
        }
        System.out.printf("%s월 %d일 %s %s%n", schedule.getMonth(), day, schedule.getDayOfWeek(day), nextWorker);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printSchedule(Schedule schedule) {
        System.out.println();
        for (int day = 1; day <= schedule.getLastDay(); day++) {
            Worker nextWorker = schedule.getNextWorker(day);
            printScheduleByDay(schedule, day, nextWorker.nickname());
        }
    }
}
