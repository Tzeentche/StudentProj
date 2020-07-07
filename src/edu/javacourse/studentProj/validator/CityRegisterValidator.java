package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.domain.register.AnswerCityRegister;
import edu.javacourse.studentProj.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentProj.domain.register.CityRegisterResponse;
import edu.javacourse.studentProj.exception.CityRegisterException;

import java.util.List;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    private String login;
    String password;

    private FakeCityRegisterChecker personChecker;

    public CityRegisterValidator(String hostName) {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

        checkPerson(so.getHusband());
        checkPerson(so.getWife());

        for (Child child : so.getChildren()) {
                checkPerson(child);
            }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {

        try {
            CityRegisterResponse cans = personChecker.checkPerson(person);

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }

        return null;
    }
}
