package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.AnswerCityRegister;
import edu.javacourse.studentProj.domain.StudentOrder;

public class CityRegisterValidator {

    String hostName;
    String login;
    String password;

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister check is running:" + hostName + "," + login + "," + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
