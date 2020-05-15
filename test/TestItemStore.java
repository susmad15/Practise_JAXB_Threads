/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import itemstore.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import itemstore.ItemStore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wp
 */
public class TestItemStore {
    
    public TestItemStore () {
    }
    
    @Test
    public void testSingletonConstructor () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        // test that there is NO Constructor of the class
        
        boolean success = false;
        try {
            // delay must be public for this to work
            Class itemStoreClass = Class.forName("itemstore.ItemStore");
            int n = itemStoreClass.getClass().getConstructors ().length;
            success = n == 0;
        }
        catch ( Exception ex ) {
            success = false;
        }
        
        assertEquals(true, success);
    }
    
    
    @Test
    public void testGetInstance () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        ItemStore item1 = ItemStore.getInstance ();
        ItemStore item2 = ItemStore.getInstance ();

        assertEquals(item1, item2);
    }
    
    @Test
    public void testAddItem () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        // get new instance of itemStore
        
        ItemStore store = ItemStore.getInstance ();

        // test if EXACTLY ONE item is there 
        
        assertEquals(1, store.getItems ().size());
        
        // add a second item
        Item newItem = new Item(store.peek ().getHash ());
        //Item newItem = new Item(store.peek ().getData ());
        store.addItem ( newItem );
        
        // test if the itemStore is valid
        assertTrue ( store.isStoreValid () );
        
        
        // add a third item with a wrong hash
        newItem = new Item("such a bad hash");
        store.addItem ( newItem );

        // test if the itemStore is valid
        assertFalse ( store.isStoreValid () );
        
    }
    
    @Test
    public void testAddFalseItem () {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        
        // get new instance of itemStore
        
        ItemStore itemStore = ItemStore.getInstance ();

        
        // add a third item with a wrong hash
        Item newItem = new Item("such a bad hash");
        itemStore.addItem ( newItem );

        // test if the itemStore is valid
        assertFalse ( itemStore.isStoreValid () );
        
    }


    
    
}
