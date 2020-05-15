/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import itemstore.Item;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author wp
 */
public class TestItem {
    
    public TestItem () {
    }
    
    @Test
    public void testItemCreation() {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        Item firstItem = new Item (null);
        Item secondItem = new Item (firstItem.getHash ());

        // test if the two generated Items exist.
        
        Assert.assertNotNull (firstItem);
        Assert.assertNotNull (secondItem);
    }

    @Test
    public void testHashCodes() {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        Item firstItem = new Item (null);
        Item secondItem = new Item (firstItem.getHash ());
        secondItem.setPreviousItem ( firstItem);

        // test if the hashes are 64 characters long
        Assert.assertEquals (64, firstItem.getHash ().length ());
        Assert.assertEquals (64, secondItem.getHash ().length ());

        // test if the firstItem is the previous to secondItem
        
        Assert.assertEquals (firstItem.getHash (), secondItem.getPreviousHash ());
        
        // test that they are not linked (yet!)
        Assert.assertEquals (null, firstItem.getPreviousItem ());
        Assert.assertNotEquals (null, secondItem.getPreviousItem ());
        
    }
    
    @Test
    public void testItemLinking() {
        Logger.getLogger ( this.getClass ().getName () ).log ( Level.INFO, "" );
        Item firstItem = new Item (null);
        Item secondItem = new Item (firstItem.getHash ());

        secondItem.setPreviousItem ( firstItem);
        
        // test that they are correctly linked
        // this tests the getter and setter for Item
        
        Assert.assertEquals (null, firstItem.getPreviousItem ());
        Assert.assertEquals (firstItem, secondItem.getPreviousItem ());
        
    }


    
}
