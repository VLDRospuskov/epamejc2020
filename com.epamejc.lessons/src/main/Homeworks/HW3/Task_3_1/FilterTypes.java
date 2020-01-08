package main.Homeworks.HW3.Task_3_1;

public enum FilterTypes {
    EVEN("even"),
    ODD("odd");

    private String value;

    FilterTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
