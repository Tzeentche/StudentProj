package edu.javacourse.studentProj.domain;

public class University {

    private Long universityId;
    private String UniverstyName;

    public University() {
    }

    public University(Long universityId, String universtyName) {
        this.universityId = universityId;
        UniverstyName = universtyName;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniverstyName() {
        return UniverstyName;
    }

    public void setUniverstyName(String universtyName) {
        UniverstyName = universtyName;
    }
}
