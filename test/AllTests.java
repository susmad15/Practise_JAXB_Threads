/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author wp
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestItem.class,
    TestItemStore.class,
    TestThreadLauncher.class,
    TestItemStoreController.class
    
})
public class AllTests {

}
