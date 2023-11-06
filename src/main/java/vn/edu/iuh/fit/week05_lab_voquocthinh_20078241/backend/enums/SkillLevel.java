package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums;

public enum SkillLevel {
    BEGINER(0),
    IMTERMEDIATE(1),
    ADVANCED(2),
    PROFESSIONAL(3),
    MASTER(4);

    private int value;

    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
