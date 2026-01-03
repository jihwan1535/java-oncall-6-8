package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.CustomException;
import oncall.exception.ExceptionMessage;

public record Workers(List<Worker> workers) {

    private static final int REQUIRES_MIN_WORKERS = 5;
    private static final int REQUIRES_MAX_WORKERS = 35;

    public Workers {
        if (new HashSet<>(workers).size() != workers.size()) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
        if (workers.size() < REQUIRES_MIN_WORKERS || workers.size() > REQUIRES_MAX_WORKERS) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public static Workers fromWorkerNames(List<String> workerNames) {
        List<Worker> workers = workerNames.stream()
                .map(Worker::new)
                .toList();
        return new Workers(workers);
    }
}
