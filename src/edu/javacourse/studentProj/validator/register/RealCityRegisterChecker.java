package edu.javacourse.studentProj.validator.register;

import edu.javacourse.studentProj.validator.register.CityRegisterChecker;
import edu.javacourse.studentProj.validator.register.CityRegisterResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;
import edu.javacourse.studentProj.exception.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {

        return null;
    }
}
