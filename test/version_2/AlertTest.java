package version_2;

import class_package.Alert;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vlad on 28.09.2016.
 */
public class AlertTest {

    private final TestInterface<Alert> ti = new TestInterface<Alert>() {
        @Override
        public Alert newInstance() {
            return new Alert(0,0,0, "",0, "", "", true, 0);
        }

        @Override
        public void doTest(Alert base, Alert current) {
            Alert copy = current.copy();
            Assert.assertEquals("Copy not idential", copy, current);
            Assert.assertEquals("Hash copy not idential", copy.hashCode(), current.hashCode());
        }
    };
    @Test
    public void copy() throws Exception {
        Map<String, ValuesProvider> map = new HashMap<String, ValuesProvider>();

        map.put("apamaInstanceId", new LongValuesProvider(0,1));
        map.put("id", new LongValuesProvider(0,2));
        Alert alert = new Alert(0,0,0, "",0, "", "", true, 0 );
        GlobalGenerator<Alert> generator = new GlobalGenerator<Alert>( alert,map, ti);
        generator.doTestAll();
    }

    @Test
    public void equals() throws Exception {

    }

   /*@Test
   public void hashCode() throws Exception {

   }
   */

}