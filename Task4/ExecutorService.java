package Task4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorService implements Executor {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<WorkerThread> threads;

    public ExecutorService(int numThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.threads = new LinkedList<>();

        for (int i = 0; i < numThreads; i++) {
            WorkerThread thread = new WorkerThread();
            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public void execute(Runnable command) {
        try {
            taskQueue.put(command);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public void shutdown() {
        for (WorkerThread thread: threads) {
            thread.interrupt();
        }
    }
}
