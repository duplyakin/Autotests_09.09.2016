package version_2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vlad on 26.09.2016.
 */
public class GlobalGenerator<C> {
    private Map<String, ValuesProvider> fieldsToTest;
    private C base;
    private TestInterface<C> test;

    public GlobalGenerator(C base, Map<String, ValuesProvider> fieldsToTest, TestInterface<C> test) {
        this.fieldsToTest = fieldsToTest;
        this.base = base;
        this.test = test;
    }

    public void doTestAll() throws NoSuchFieldException, IllegalAccessException {
        Set<String> fields = fieldsToTest.keySet();
        ArrayList<String> aFields = new ArrayList<>(fields);
        if (aFields.size() > 0) {
            doTestOne(base, aFields, 0);
        }
    }

    protected void doTestOne(C base, ArrayList<String> aFields, int current) throws NoSuchFieldException, IllegalAccessException {
        if (current < aFields.size()) {
            String currentField = aFields.get(current);
            ValuesProvider valuesProvider = fieldsToTest.get(currentField);
            SingleFieldGenerator<C> sfg = new SingleFieldGenerator<C>(base, currentField, test, valuesProvider);
            while (sfg.hasNext()) {
                C c = sfg.next();
                try {
                    test.doTest(base, c);
                }catch (Throwable e){
                    e.printStackTrace();
                }

                doTestOne(c, aFields, current + 1);
            }

        }
    }
}
