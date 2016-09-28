package version_2;

import com.sun.istack.internal.NotNull;

/**
 * Created by Vlad on 26.09.2016.
 */
public interface TestInterface<C> {

    @NotNull
    C newInstance();

    void doTest(C base, C current);
}
