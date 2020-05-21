package threads;

import itemstore.ItemStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ThreadLauncher {

    protected String[] names;

    protected List<Thread> threads;

    protected int nThreads;

    protected Random random;

    protected ItemStore store;

    protected volatile boolean thread_exit;

    public ThreadLauncher(String[] names) {
        this.names = names;
        threads = new ArrayList<>();
        nThreads = 0;
        random = new Random();
        store = ItemStore.getInstance();
        thread_exit = false;
        
        // Start all Threads
        System.err.println("Starting all Threads!");
        launchThreads();
        
        // Wait 3 Seconds then kill all threads
        System.err.println("Waiting 3 Seconds before killing all Threads!");
        delay(3000);
        killAllThreads();
        
        // Wait if all Threads are finished
        System.err.println("Waiting for all Threads to be finished!");
        waitForFinish();
        
        System.err.println("All Threads are dead now!");
        
    }

    public void delay(int msecs) {
        try {
            Thread.sleep(msecs);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void launchThreads() {
        Stream.of(names)
                .forEach(n -> {
                    Thread t = new Thread(() -> work());
                    t.setName(n);

                    threads.add(t);
                });
        
        threads.stream()
               .forEach(Thread::start);

        nThreads = threads.size();

        System.out.println("Anzahl an Threads: " + nThreads);
    }
    
    public void startAllThreads() {
        threads.stream()
               .forEach(Thread::start);
    }

    public void waitForFinish() {
        while (threads.stream().anyMatch(Thread::isAlive)) {
            delay(1000);
        }
    }

    protected void work() {

        while (!thread_exit) {

            delay(100);

            String threadName = Thread.currentThread().getName();

            synchronized (store) {
                store.getItems().stream()
                        .forEach(block -> {
                            String data = String.format("%3d", (random.nextInt(20) - 15));
                            System.out.printf(" %s: Working on item %s, data=%s ... \n",
                                    threadName, block.getData(), data);
                        });
            }
        }

    }
    
    public void killAllThreads() {
        thread_exit = true;
    }

    public static void main(String[] args) {

        String[] names = {"T1", "T2", "T3", "T4", "T5"};

        ThreadLauncher tl = new ThreadLauncher(names);

        tl.launchThreads();
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public int getnThreads() {
        return nThreads;
    }

    public void setnThreads(int nThreads) {
        this.nThreads = nThreads;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public ItemStore getStore() {
        return store;
    }

    public void setStore(ItemStore store) {
        this.store = store;
    }

    public boolean isThread_exit() {
        return thread_exit;
    }

    public void setThread_exit(boolean thread_exit) {
        this.thread_exit = thread_exit;
    }
    
    

}
