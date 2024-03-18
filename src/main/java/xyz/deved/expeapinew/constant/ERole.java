package xyz.deved.expeapinew.constant;

public enum ERole {
  ROLE_USER(2),
  ROLE_EMPLOYEE(3),
  ROLE_ADMIN(1);

  private final int value;

  ERole(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
