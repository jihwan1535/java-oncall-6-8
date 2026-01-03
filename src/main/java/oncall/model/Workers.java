package oncall.model;

import java.util.ArrayList;
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
        workers = new ArrayList<>(workers);
    }

    public static Workers fromWorkerNames(List<String> workerNames) {
        List<Worker> workers = workerNames.stream()
                .map(Worker::new)
                .toList();
        return new Workers(workers);
    }

    public Worker getNextWorker(Worker prevWorker) {
        if (prevWorker == null) {
            return workers.get(0);
        }
        int prevWorkerIndex = workers.indexOf(prevWorker);
        int nextWorkerIndex = (prevWorkerIndex + 1) % workers.size();
        return workers.get(nextWorkerIndex);
    }

    public void swapNext(Worker worker) {
        int workerIndex = workers.indexOf(worker);
        int nextWorkerIndex = (workerIndex + 1) % workers.size();
        workers.set(workerIndex, workers.get(nextWorkerIndex));
        workers.set(nextWorkerIndex, worker);
    }

    public boolean isNotSame(Workers holidayWorkers) {
        return holidayWorkers.workers.stream()
                .anyMatch(worker -> !this.workers.contains(worker));
    }
}
