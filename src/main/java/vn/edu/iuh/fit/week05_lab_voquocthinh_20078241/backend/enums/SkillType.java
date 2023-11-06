package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums;

public enum SkillType {
    UNSPECIFIC(0),
    TECHNICAL_SKILL(1),
    SOFT_SKILL(2);

    private int value;

    SkillType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
