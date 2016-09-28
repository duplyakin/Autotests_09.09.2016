package version_2;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;

/**
 * Created by Vlad on 26.09.2016.
 */
public class SingleFieldGenerator<C> implements ValuesProvider<C> {
    private ValuesProvider dataset;
    private C base;
    private Class<C> cClass;
    private Field f;
    TestInterface<C> ti;

    public SingleFieldGenerator(@NotNull C base, @NotNull String fieldname, @NotNull TestInterface<C> ti, @NotNull ValuesProvider dataset) throws NoSuchFieldException {
        this.dataset = dataset;
        this.base = base;
        cClass = (Class<C>) base.getClass();
        this.ti = ti;
        f = cClass.getDeclaredField(fieldname);
        f.setAccessible(true);
    }

    /*
    * private static final String INT_CLASS_NAME =int.class.getName()
    * Switch INT_CLASS_NAME
    *
    *
    * private static final String INT_CLASS_NAME ="int"
    *
    * */
    public C copy(C from) throws IllegalAccessException {
        C obj = ti.newInstance();
        Field[] fields = cClass.getDeclaredFields();
        for (Field f : fields) {
            if (!f.isAccessible())
                f.setAccessible(true);
            String str = f.getType().getName();
            switch (f.getType().getTypeName()) {
                case "boolean": {
                    boolean val = f.getBoolean(base);
                    f.setBoolean(obj, val);
                }
                break;
                case "byte": {
                    byte val = f.getByte(base);
                    f.setByte(obj, val);
                }
                break;
                case "char": {
                    char val = f.getChar(base);
                    f.setChar(obj, val);
                }
                break;
                case "short": {
                    short val = f.getShort(base);
                    f.setShort(obj, val);
                }
                break;
                /*case "int": {
                    int val = f.getInt(base);
                    f.setInt(obj, val);
                }
                break;*/
                /*case "long": {
                    long val = f.getLong(base);
                    f.setLong(obj, val);
                }
                break;*/
                case "float": {
                    float val = f.getFloat(base);
                    f.setFloat(obj, val);
                }
                break;
                case "double": {
                    double val = f.getDouble(base);
                    f.setDouble(obj, val);
                }
                break;
                default: {
                    Object val = f.get(base);
                    f.set(obj, val);
                }
            }

            /*
            if (f.getType() == boolean.class) {
                boolean val = f.getBoolean(base);
                f.setBoolean(obj, val);
            } else if (f.getType() == byte.class) {
                byte val = f.getByte(base);
                f.setByte(obj, val);
            } else if (f.getType() == char.class) {
                char val = f.getChar(base);
                f.setChar(obj, val);
            } else if (f.getType() == short.class) {
                short val = f.getShort(base);
                f.setShort(obj, val);
            } else if (f.getType() == int.class) {
                int val = f.getInt(base);
                f.setInt(obj, val);
            } else if (f.getType() == long.class) {
                long val = f.getLong(base);
                f.setLong(obj, val);
            } else if (f.getType() == float.class) {
                float val = f.getFloat(base);
                f.setFloat(obj, val);
            } else {
                Object val = f.get(base);
                f.set(obj, val);
            }
            */
        }
        return obj;
    }

    ;


    @Override
    public C next() throws IllegalAccessException {

        C obj = copy(base);
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
