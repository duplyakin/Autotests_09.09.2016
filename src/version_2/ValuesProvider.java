package version_2;

/**
 * Created by vlad on 21.09.16.
 */
public interface ValuesProvider<E> {
    E next();
    boolean hasNext();
    void reset();
}
