package edu.javacourse.studentProj.domain;

public class Street {

    private Long streetCod;
    private String streetName;

    public Street() {
    }

    public Street(Long streetCod, String streetName) {
        this.streetCod = streetCod;
        this.streetName = streetName;
    }

    public Long getStreetCod() {
        return streetCod;
    }

    public void setStreetCod(Long streetCod) {
        this.streetCod = streetCod;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
