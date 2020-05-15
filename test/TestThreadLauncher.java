/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import threads.ThreadLauncher;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wp
 */
public class TestThreadLauncher {

    public TestThreadLauncher () {
    }

    String[] names = { "T1", "T2", "T3", "T4" };
    
    
    @Test
    // test if al methods in ThreadLauncher have been implemented.
    public void testMethodDefinitions ()  {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        ThreadLauncher launcher = new ThreadLauncher ( names );
        assertEquals ( names.length, launcher.getNames ().length);
        
        assertNotEquals ( null, launcher.getThreads ());
        
        assertNotEquals ( null, launcher.getnThreads ());
        
        
        boolean success = false;
        try {
            // delay must be public for this to work
            launcher.getClass().getDeclaredMethod ("delay", int.class);
            success = true;
        }
        catch ( Exception ex ) {
            ex.printStackTrace ();
            System.out.println (ex.getMessage ());
            success = false;
        }
        assertEquals ( true, success);
        launcher.waitForFinish ();
    }

    @Test
    public void testIfThreadsAreRunning () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
    
        // I am not going to tell you how you DO THIS WITH STREAMS!
        // in your ThreadLauncher class you must use streams, NO for-loops
        
        ThreadLauncher launcher = new ThreadLauncher ( names );
        assertEquals ( true, launcher.getThreads().get(0).isAlive ());
        launcher.waitForFinish ();
        
    }
    
    
    @Test
    // test successful runs of all threads (they must be terminated
    public void testIfThreadsAreTerminated () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        ThreadLauncher launcher = new ThreadLauncher ( names );
        List<Thread> threads = launcher.getThreads ();

        launcher.waitForFinish ();

        assertEquals ( names.length, threads.size () );
        
        assertEquals ( false, launcher.getThreads().get(0).isAlive ());
    }
}
