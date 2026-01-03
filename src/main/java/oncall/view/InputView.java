package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import oncall.controller.OnCallDate;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;
import oncall.model.DayOfWeek;
import oncall.model.Month;

public class InputView {

    private static String[] parseTokens(String text) {
        return text.split(",");
    }

    public OnCallDate readOnCallDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String[] tokens = parseTokens(Console.readLine());
        if (tokens.length != 2) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
        return new OnCallDate(Month.from(tokens[0]), DayOfWeek.from(tokens[1]));
    }

    public List<String> readWeekDayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Arrays.stream(parseTokens(Console.readLine())).toList();
    }

    public List<String> readHolidayWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Arrays.stream(parseTokens(Console.readLine())).toList();
    }
}
