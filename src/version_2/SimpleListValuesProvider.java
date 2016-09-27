package version_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 26.09.2016.
 */
public class SimpleListValuesProvider<F> implements ValuesProvider<List<F>> {

    private List<List<F>> lvals;
    int current = 0;
    public SimpleListValuesProvider(F... vals) {
        lvals = new ArrayList<>(vals.length);
        for (F val : vals) {
            List<F> lval = new ArrayList<F>();
            lval.add(val);
            lvals.add(lval);
        }
    }

    @Override
    public List<F> next() {
        return lvals.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < lvals.size();
    }

    @Override
    public void reset() {
        current = 0;
    }
}
