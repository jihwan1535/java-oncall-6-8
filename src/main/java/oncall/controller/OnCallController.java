package oncall.controller;

import oncall.view.InputView;

public class OnCallController {

    private final InputView inputView = new InputView();

    public void run() {
        OnCallDate onCallDate = inputView.readOnCallDate();
    }
}
