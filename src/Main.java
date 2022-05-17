public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener taskErr = x -> (x == 33) ? 0 : 1; // значение 0 - ошибка; 1 - корректно.

        Worker worker = new Worker(listener, taskErr);
        worker.start();
    }
}
