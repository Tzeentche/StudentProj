package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.validator.register.CityRegisterResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;
import edu.javacourse.studentProj.exception.TransportException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException;
}
