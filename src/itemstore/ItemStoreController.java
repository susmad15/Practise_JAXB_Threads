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

    public void runItemStore() {

        store = ItemStore.getInstance();

        names = new String[]{"T1", "T2", "T3", "T4", "T5"};

        launcher = new ThreadLauncher(names);
        producerlauncher = new ProducerLauncher(new String[]{"P1", "P2", "P3", "P4", "P5"});
        consumerlauncher = new ConsumerLauncher(new String[]{"C1", "C2", "C3", "C4", "C5"});
        launcherxml = new MonitorLauncherXML(2);
        launcherjson = new MonitorLauncherJSON(2);
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
