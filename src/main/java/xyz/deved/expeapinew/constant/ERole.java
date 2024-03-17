package xyz.deved.expeapinew.constant;

public enum ERole {
    ROLE_ADMIN(1),
    ROLE_USER(2),
    ROLE_EMPLOYEE(3);


    private final int value;

    ERole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
