package version_2;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlad on 20.09.16.
 */
public class ATest {

    private  final TestInterface<A> ti = new TestInterface<A>() {

        @Override
        public A newInstance() {
            return new A(0, SomeTestEnum.FIRST, new ArrayList<String>(), null);
        }

        @Override
        public void doTest(A base, A current) {
            A copy = current.copy();
            Assert.assertEquals("Copy not idential", copy, current);
            Assert.assertEquals("Hash copy not idential", copy.hashCode(), current.hashCode());

        }
    };

    @org.junit.Test
    public void copy() throws Exception {
        Map<String, ValuesProvider> map = new HashMap<String, ValuesProvider>();

        map.put("a", new IntValuesProvider(0, 10));
        map.put("ste", new EnumValuesProvider<SomeTestEnum>(SomeTestEnum.values()));
        map.put("someList", new SimpleListValuesProvider<String>("aaa", "bbb", "ccc"));

        /*
        System.out.println(int.class.getName());
        System.out.println(char.class.getName());
        System.out.println(short.class.getName());
        System.out.println(long.class.getName());
        System.out.println(byte.class.getName());
        System.out.println(boolean.class.getName());
        System.out.println(float.class.getName());
        System.out.println(double.class.getName());
        */
        System.out.println(double.class.getName());


        List list = new ArrayList<String>();
        A a = new A(0, SomeTestEnum.FIRST, list, null);
        //A a = new A();
        GlobalGenerator<A> generator = new GlobalGenerator<>(a, map, ti);
        generator.doTestAll();
    }

    @org.junit.Test
    public void equals() throws Exception {

    }



}