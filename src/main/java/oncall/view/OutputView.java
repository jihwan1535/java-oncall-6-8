package oncall.view;

import oncall.model.Schedule;

public class OutputView {

    public void printError(String message) {
        System.out.println(message);
    }

    public void printSchedule(Schedule schedule) {
        System.out.println();
        for (int day = 1; day <= schedule.getLastDay(); day++) {
            if (schedule.isWeekHoliday(day)) {
                System.out.printf("%s월 %d일 %s(휴일) %s%n", schedule.getMonth(), day, schedule.getDayOfWeek(day), "준팍");
                continue;
            }
            System.out.printf("%s월 %d일 %s %s%n", schedule.getMonth(), day, schedule.getDayOfWeek(day), "준팍");
        }
    }
}
