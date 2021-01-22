package edu.javacourse.studentProj.domain;

public class Street {

    private Long streetCode;
    private String streetName;

    public Street() {
    }

    public Street(Long streetCod, String streetName) {
        this.streetCode = streetCod;
        this.streetName = streetName;
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
