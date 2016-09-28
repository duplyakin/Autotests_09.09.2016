package version_2;


import class_package.CopyInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vlad on 13.09.16.
 */
public class A implements CopyInterface<A> {
    // 2) делаем поля private final
    private int a;
    private SomeTestEnum ste = SomeTestEnum.FIRST;
    private List<String> someList = new ArrayList<>();
    //for checking Reflection
    public String name;


    public A(int a, SomeTestEnum ste, List<String> someList, String name) {
        Objects.requireNonNull(a);
        this.a = a;
        this.ste = ste;
        this.someList = someList;
        this.name = name;
    }



    //@Override
    public int getInt() {
        return a;
    }

    //@Override
    public void setInt(int i) {
        a = i;
    }

    //@Override
    public SomeTestEnum getSomeTestEnum() {
        return ste;
    }

    //@Override
    public void setSomeTestEnum(SomeTestEnum enumValue) {
        ste = enumValue;
    }

   // @Override
    public List<String> getSomeList() {
        return someList;
    }

    //@Override
    public void setSomeList(List list) {
        someList = list;
    }

    @Override
    public A copy() {
        A dup = new A(a,ste, someList, name);
        //A dup = new A();
        dup.a = a;
        dup.ste = ste;
        //dup.someList = someList;
        dup.someList.clear(); // 3.1) Надо понимать действительно ли это нужно.(Проверить утечку везде)
        dup.someList.addAll(someList);
        return dup;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if (o == null || !(o instanceof A)) return false; // 4) instance of можно проще


        A testClass = (A) o;

        if (a != testClass.a) return false;
        if (ste != testClass.ste) return false;
        return someList.equals(testClass.someList);

    }

    // Вроде бы обработал на null
    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (ste != null ? ste.hashCode() : 0);
        result = 31 * result + (someList != null ? someList.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
