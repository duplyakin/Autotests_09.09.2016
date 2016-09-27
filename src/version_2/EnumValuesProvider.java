package version_2;

/**
 * Created by vlad on 21.09.16.
 */
public class EnumValuesProvider<E extends Enum> extends FixedSetValuesProvider<E> {
    EnumValuesProvider(E[] values) {super(values);}

    /*public EnumValuesProvider(Enum... element) {
        super(element);
    }*/
}
