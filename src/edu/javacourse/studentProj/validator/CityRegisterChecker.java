package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;

public interface CityRegisterChecker {

    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
