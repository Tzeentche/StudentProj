package edu.javacourse.studentProj.domain.register;

import edu.javacourse.studentProj.domain.Address;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.util.LocalDateAdapter;

import java.time.LocalDate;

public class CityRegisterRequest {

    private String surName;
    private String givenName;
    private String patronymic;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dateOfBirth;
    private Long streetCode;
    private String building;
    private String extension;
    private String apartment;

    public CityRegisterRequest() {
    }

    public CityRegisterRequest(Person person) {
        surName = person.getSurName();
        givenName = person.getGivenName();
        patronymic = person.getPatronymic();
        dateOfBirth = person.getDateOfBirth();
        Address adr = person.getAddress();
        streetCode = adr.getStreet().getStreetCode();
        building = adr.getBuilding();
        extension = adr.getExtension();
        apartment = adr.getApartment();
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "CityRegisterRequest{" +
                "surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", streetCode=" + streetCode +
                ", building='" + building + '\'' +
                ", extension='" + extension + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
