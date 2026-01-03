package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.controller.OnCallDate;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;
import oncall.model.DayOfWeek;
import oncall.model.Month;

public class InputView {

    public OnCallDate readOnCallDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String[] tokens = Console.readLine().split(",");
        if (tokens.length != 2) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
        return new OnCallDate(Month.from(tokens[0]), DayOfWeek.from(tokens[1]));
    }
}
