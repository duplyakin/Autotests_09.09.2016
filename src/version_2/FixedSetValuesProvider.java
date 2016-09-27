package version_2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by vlad on 21.09.16.
 */
public class FixedSetValuesProvider<E> implements ValuesProvider<E> {
    final E[] element;
    int position;

    public FixedSetValuesProvider(E... element) {
        this.element = element;
    }

    @Override
    public E next() {
        return element[position++];
    }

    @Override
    public boolean hasNext() {
        if (position < element.length) {
            return true;
        } else {
            position = 0;
            return  false;
        }
        //return position < element.length;
    }

    @Override
    public void reset() {
        position = 0;
    }

}


