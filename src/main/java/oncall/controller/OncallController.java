package oncall.controller;

import java.util.List;
import java.util.function.Consumer;
import oncall.model.Oncall;
import oncall.model.Schedule;
import oncall.model.Workers;
import oncall.utils.ExceptionHandler;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        OnCallDate onCallDate = ExceptionHandler.handle(inputView::readOnCallDate, processError());
        Oncall oncall = ExceptionHandler.handle(this::readOncall, processError());
        Schedule schedule = new Schedule(onCallDate.month(), onCallDate.dayOfWeek(), oncall);
        outputView.printSchedule(schedule);
    }

    private Oncall readOncall() {
        List<String> weekDayWorkers = inputView.readWeekDayWorkers();
        List<String> holiDayWorkers = inputView.readHolidayWorkers();
        return new Oncall(
                Workers.fromWorkerNames(weekDayWorkers),
                Workers.fromWorkerNames(holiDayWorkers)
        );
    }

    private Consumer<IllegalArgumentException> processError() {
        return (e) -> outputView.printError(e.getMessage());
    }
}
