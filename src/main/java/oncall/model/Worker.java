package oncall.model;

import java.util.Objects;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;

public class Worker {

    private final String nickname;
    private final boolean weekDayWork;

    public Worker(String nickname, boolean weekDayWork) {
        if (nickname.length() > 5) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
        this.nickname = nickname;
        this.weekDayWork = weekDayWork;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(nickname, worker.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }
}
