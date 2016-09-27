package version_2;

/**
 * Created by vlad on 13.09.16.
 */
public enum SomeTestEnum {
    FIRST("first"),
    SECOND("second");

    String data;
    SomeTestEnum(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
