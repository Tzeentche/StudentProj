package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.exception.CityRegisterException;

import java.util.Iterator;
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
        Person p = so.getHusband();

        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());

            List<Child> children = so.getChildren();

            for(int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(children.get(i));
            }

            for(Iterator<Child> it = children.iterator(); it.hasNext();) {
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

            for(Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("CityRegister check is running:" + hostName + "," + login + "," + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
