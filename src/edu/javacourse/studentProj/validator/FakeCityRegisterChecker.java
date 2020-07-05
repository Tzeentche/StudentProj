package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker{

    public CityRegisterCheckerResponse  checkPerson(Person person) throws CityRegisterException {

        return null;
    }
}
