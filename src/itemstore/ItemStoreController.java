package itemstore;

import monitor.MonitorLauncherJSON;
import monitor.MonitorLauncherXML;
import producer_consumer.ConsumerLauncher;
import producer_consumer.ProducerLauncher;
import threads.ThreadLauncher;

public class ItemStoreController {

    private ItemStore store;

    private String[] names;

    private ThreadLauncher launcher;
    private ProducerLauncher producerlauncher;
    private ConsumerLauncher consumerlauncher;
    private MonitorLauncherXML launcherxml;
    private MonitorLauncherJSON launcherjson;

    public ItemStoreController() {
        store = ItemStore.getInstance();

        names = new String[]{"T1", "T2", "T3", "T4", "T5"};

        launcher = new ThreadLauncher(names);
        producerlauncher = new ProducerLauncher(new String[]{"P1", "P2", "P3", "P4", "P5"});
        consumerlauncher = new ConsumerLauncher(new String[]{"C1", "C2", "C3", "C4", "C5"});
        launcherxml = new MonitorLauncherXML(2);
        launcherjson = new MonitorLauncherJSON(2);
        
    }

    public void runItemStore() {

        // Launch all Threads
        launcher.launchThreads();

        producerlauncher.launchThreads();

        consumerlauncher.launchThreads();
        
        launcherxml.launchThreads();
        
        launcherjson.launchThreads();

        // Starting Threads
        System.out.println("Starting all Threads");

        launcher.startAllThreads();

        producerlauncher.startAllThreads();

        consumerlauncher.startAllThreads();
        
        launcherxml.startAllThreads();
        
        launcherjson.startAllThreads();

        // Killing all Threads after 3 seconds
        System.out.println("Killing all Threads after 3 Seconds");

        launcher.delay(3000);
        launcher.killAllThreads();

        producerlauncher.delay(3000);
        producerlauncher.killAllThreads();

        consumerlauncher.delay(3000);
        consumerlauncher.killAllThreads();
        
        launcherxml.delay(3000);
        launcherxml.killAllThreads();
        
        launcherjson.delay(3000);
        launcherjson.killAllThreads();

        // Waiting if all Threads are finished
        System.out.println("Waiting for all Threads to be killed");

        launcher.waitForFinish();

        producerlauncher.waitForFinish();

        consumerlauncher.waitForFinish();
        
        launcherxml.waitForFinish();
        
        launcherjson.waitForFinish();

        // All Threads killed
        System.out.println("All Threads killed now!");

    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public int getnItems() {
        return launcher.getnThreads() + producerlauncher.getnThreads() + consumerlauncher.getnThreads();
        //return store.getItems().size();
    }

    public static void main(String[] args) {
        ItemStoreController controller = new ItemStoreController();

        controller.runItemStore();
    }
}
