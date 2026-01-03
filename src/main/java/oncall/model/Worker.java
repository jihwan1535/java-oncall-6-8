package oncall.model;

import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;

public record Worker(String nickname) {

    public Worker {
        if (nickname.length() > 5) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
    }
}
