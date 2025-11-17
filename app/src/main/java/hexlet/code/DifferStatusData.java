package hexlet.code;

public final class DifferStatusData {
    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private String statusName;
    private String keyValue;
    private Object oldValue;
    private Object newValue;

    DifferStatusData(String statusname, String keyvalue, Object oldvalue, Object newvalue) {
        this.statusName = statusname;
        this.keyValue = keyvalue;
        this.oldValue = oldvalue;
        this.newValue = newvalue;
    }
    DifferStatusData(String statusname, String keyvalue, Object oldvalue) {
        this.statusName = statusname;
        this.keyValue = keyvalue;
        this.oldValue = oldvalue;
        this.newValue = null;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
