public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener taskErr = System.out::println;

        Worker worker = new Worker(listener, taskErr);
        worker.start();
    }
}
