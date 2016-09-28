package class_package;

import java.util.List;

/**
 * Created by vlad on 13.09.16.
 */
public interface CopyInterface<E> {

    /*
    int getInt();
    void setInt(int i);

    SomeTestEnum getSomeTestEnum();
    void setSomeTestEnum(SomeTestEnum enumValue);

    List<String> getSomeList();
    void setSomeList(List<String> list);
    */

    E copy();

}
