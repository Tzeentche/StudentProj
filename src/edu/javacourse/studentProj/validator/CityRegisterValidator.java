package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.AnswerCityRegister;
import edu.javacourse.studentProj.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.domain.StudentOrder;
import edu.javacourse.studentProj.exception.CityRegisterException;

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
        Person p = so.getHusband();

        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }

        CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
        CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChild());

        System.out.println("CityRegister check is running:" + hostName + "," + login + "," + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
