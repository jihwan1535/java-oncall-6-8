package oncall.controller;

import java.util.List;
import java.util.function.Consumer;
import oncall.utils.ExceptionHandler;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        OnCallDate onCallDate = ExceptionHandler.handle(inputView::readOnCallDate, processError());
        List<String> weekDayWorkers = inputView.readWeekDayWorkers();
        List<String> holiDayWorkers = inputView.readHolidayWorkers();
    }

    private Consumer<IllegalArgumentException> processError() {
        return (e) -> outputView.printError(e.getMessage());
    }
}
