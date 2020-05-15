/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import itemstore.ItemStoreController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wp
 */
public class TestItemStoreController {
    
    ItemStoreController controller = new ItemStoreController ();
    
    public TestItemStoreController () {
    }
    
    @Test
    public void testItemStoreController ()
    {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        assertNotNull(controller);
        
    }

    @Test
    public void testItemStoreControllerResults () 
    {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        controller.setNames ( new String[] {"T1", "T2", "T3", "T4"});
        
        controller.runItemStore ();
        // we can have two results, depending if everything is tested,
        // or this test separately. we get either 5, or 20
        boolean success = (controller.getnItems() == 5 
                || controller.getnItems() == 20);
        assertTrue ( success);
//        assertTrue (controller.getIsValid ());
        
    }

    
}
