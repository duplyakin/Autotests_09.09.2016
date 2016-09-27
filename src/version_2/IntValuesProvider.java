package version_2;

/**
 * Created by vlad on 21.09.16.
 */
public class IntValuesProvider extends FixedSetValuesProvider<Integer> {
    IntValuesProvider(int min, int max) {
        super(fill(min, max));
    }

    static Integer[] fill(int min, int max) {
        final Integer[] result = new Integer[max - min + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = min + i;
        }
        return result;
    }


}
