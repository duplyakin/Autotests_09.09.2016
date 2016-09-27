package version_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 13.09.16.
 */
public class Generator<E> {

    private static int[] allInts = {0, 1, 2, 3, 4};
    private static List<String>[] allStrings = makeAllStrings();

    private static List<String>[] makeAllStrings() {
        List<String> data[] = new List[]{new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()};
        data[0].add("a");
        data[1].add("bb");
        data[2].add("ccc");
        return data;
    }


    /*
    E nextInt() {
        CopyInterface<E> dup = (CopyInterface<E>) base.copy();
        int value = dup.getInt();
        value = (value + 1) % 5;
        dup.setInt(value);
        base = dup;
        return (E) base;
    }

    E nextList() {
        CopyInterface<E> dup = (CopyInterface<E>) base.copy();
        List<String> list = dup.getSomeList();
        list.add(list.size() + "");
        if (list.size() > 10) {
            list.clear();
        }
        base = dup;
        return (E) base;
    }

    */
    public E[] generateAllData(Class<E> clazz) throws IllegalAccessException, InstantiationException {
        int intsLength = allInts.length;
        int listOfStringsLength = allStrings.length;
        int enumLength = SomeTestEnum.values().length;

        E[] allData = (E[]) Array.newInstance(clazz, intsLength * listOfStringsLength * enumLength);
        int cur = 0;
        for (int i = 0; i < intsLength; ++i) {
            for (int j = 0; j < listOfStringsLength; ++j) {
                for (int k = 0; k < enumLength; ++k) {
                    CopyInterface<E> next = (CopyInterface<E>) clazz.newInstance();
                    next.setInt(allInts[i]);
                    next.setSomeList(allStrings[j]);
                    next.setSomeTestEnum(SomeTestEnum.values()[k]);
                    allData[cur++] = (E) next;
                }
            }
        }
        return allData;
    }


}
