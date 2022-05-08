public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
        this.errorCallback = x -> (x == 33) ? 0 : 1; // значение 0 - ошибка; 1 - корректно.
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            switch (errorCallback.onError(i)) {
                case 1 -> callback.onDone("Task " + i + " is done");
                case 0 -> callback.onDone("Task " + i + " is Not done correct");
            }
        }
    }
}
