package monitor;

import itemstore.ItemStore;
import javax.xml.bind.JAXB;
import threads.ThreadLauncher;

public class MonitorLauncherXML extends ThreadLauncher {
    
    private int delta_sec;

    public MonitorLauncherXML(int delta_sec) {
        super(new String[]{"XML1", "XML2", "XML3", "XML4", "XML5"});
        
        store = ItemStore.getInstance();
        
        this.delta_sec = delta_sec;
    }

    @Override
    protected void work() {
        while (!thread_exit) {            
            
            delay(delta_sec * 100);
            
            synchronized(store) {
                JAXB.marshal(store, System.out);
            }
        }
    }

}
