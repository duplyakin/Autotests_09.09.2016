package version_2;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;

/**
 * Created by Vlad on 26.09.2016.
 */
public class SingleFieldGenerator<C extends CopyInterface<C>> implements ValuesProvider<C> {
    private ValuesProvider dataset;
    private C base;
    private Class<C> cClass;
    private Field f;

    public SingleFieldGenerator(@NotNull C base, @NotNull String fieldname, @NotNull ValuesProvider dataset) throws NoSuchFieldException {
        this.dataset = dataset;
        this.base = base;
        cClass = (Class<C>) base.getClass();
        f = cClass.getDeclaredField(fieldname);
        f.setAccessible(true);
    }

    @Override
    public C next() {
        C obj = base.copy();
        Object val = dataset.next();

        try {
            f.set(obj, val);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public boolean hasNext() {
        return dataset.hasNext();
    }

    @Override
    public void reset() {
        dataset.reset();
    }
}
