package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentProj.domain.Person;

public interface CityRegisterChecker {

    CityRegisterCheckerResponse checkPerson(Person person);
}
