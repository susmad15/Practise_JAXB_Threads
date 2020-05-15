package itemstore;

import threads.ThreadLauncher;


public class ItemStoreController {
    
    public void runItemStore() {
        String[] names = {"T1", "T2", "T3", "T4", "T5"};
        
        ItemStore store = ItemStore.getInstance();
        
        ThreadLauncher launcher = new ThreadLauncher(names);
        
        launcher.launchThreads();
        
        // Starting Threads
        System.out.println("Starting all Threads");
        launcher.getThreads()
                .stream()
                .forEach(t -> t.start());
        
        // Killing all Threads after 3 seconds
        System.out.println("Killing all Threads after 3 Seconds");
        launcher.delay(3000);
        launcher.killAllThreads();
        
        // Waiting if all Threads are finished
        System.out.println("Waiting for all Threads to be killed");
        launcher.waitForFinish();
        
        // All Threads killed
        System.out.println("All Threads killed now!");
        
        
    }
    
    public static void main(String[] args) {
        ItemStoreController controller = new ItemStoreController();
        
        controller.runItemStore();
    }
}
