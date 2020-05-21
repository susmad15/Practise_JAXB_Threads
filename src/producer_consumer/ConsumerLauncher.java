package producer_consumer;

import threads.ThreadLauncher;

public class ConsumerLauncher extends ThreadLauncher {

    public ConsumerLauncher(String[] names) {
        super(names);
    }

    @Override
    protected void work() {
        final String threadName = Thread.currentThread().getName();

        while (!thread_exit) {
            delay(100);

            synchronized (store) {

                System.out.println(
                        "  " + threadName + " - consuming "
                        + store.peek().getData()
                );
                
                store.removeItem(store.peek());
            }
        }
    }
}
