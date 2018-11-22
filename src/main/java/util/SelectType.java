package util;

public enum SelectType {

    EMPLOYEE_TYPE(1), PRODUCT_TYPE(2);

    private int value;

    private SelectType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
