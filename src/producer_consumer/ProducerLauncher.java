package producer_consumer;

import itemstore.Item;
import threads.ThreadLauncher;

public class ProducerLauncher extends ThreadLauncher {

    public ProducerLauncher(String[] names) {
        super(names);
    }

    @Override
    protected void work() {
        final String threadName = Thread.currentThread().getName();

        while (!thread_exit) {
            delay(100);

            synchronized (store) {

                final Item i = new Item(store.peek().getHash());
                store.addItem(i);

                System.out.println(
                        " " + threadName + " - produced: "
                        + store.peek().getData()
                );
            }
        }
    }

}
