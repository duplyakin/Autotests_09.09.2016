package version_2;

/**
 * Created by Vlad on 28.09.2016.
 */
public class LongValuesProvider extends FixedSetValuesProvider<Long> {
    LongValuesProvider(int min, int max) {
        super(fill(min, max));
    }

    static Long[] fill(int min, int max) {
        final Long[] result = new Long[max - min + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] =Long.valueOf(min + i);
        }
        return result;
    }


}
