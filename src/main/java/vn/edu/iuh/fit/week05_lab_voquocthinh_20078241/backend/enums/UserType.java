package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums;

public enum UserType {
    COMPANY_USER(0),
    CANDIDATE_USER(1);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
