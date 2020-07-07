package edu.javacourse.studentProj.domain.register;

import edu.javacourse.studentProj.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class CityError {

        private String code;
        private String text;
    }

    private CityStatus status;
    private Person person;
    private CityError error;

    public AnswerCityRegisterItem(CityStatus status, Person person) {
        this.status = status;
        this.person = person;
    }

    public AnswerCityRegisterItem(CityStatus status, Person person, CityError error) {
        this.status = status;
        this.person = person;
        this.error = error;
    }

    public CityStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public CityError getError() {
        return error;
    }
}
