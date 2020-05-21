package monitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import threads.ThreadLauncher;

public class MonitorLauncherJSON extends ThreadLauncher{
    
    private int delta_sec;
    
    public MonitorLauncherJSON(int delta_sec) {
        super(new String[] {"JSON1", "JSON2", "JSON3", "JSON4", "JSON5"});
        
        this.delta_sec = delta_sec;
    }

    @Override
    protected void work() {
        while (!thread_exit) {    
            
            delay(delta_sec * 100);
            
            synchronized(store) {
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                
                String jsonString = gson.toJson(store.getItems());
                
                System.out.println(jsonString);
            }
        }
    }
    
    
    
}
