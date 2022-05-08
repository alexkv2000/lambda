public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
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
