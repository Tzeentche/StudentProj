package edu.javacourse.studentProj.mail;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.validator.ChildrenValidator;
import edu.javacourse.studentProj.validator.CityRegisterValidator;
import edu.javacourse.studentProj.validator.StudentValidator;
import edu.javacourse.studentProj.validator.WeddingValidator;


public class StudentOrderValidator {

    public static void main(String[] args) {
        static void checkAll() {
            while(true) {
                StudentOrder so = readStudentOrder();
                System.out.println("Start");
                if (so == null) {
                    break;
                }

                System.out.println("Finish");

                AnswerCityRegister cityAnswer = checkCityRegister(so);
                if (!cityAnswer.success) {
                    //
                    //continue;
                    break;
                }

                AnswerWedding wedAnswer = checkWedding(so);
                AnswerChildren childrenAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
            }
        }

        static StudentOrder readStudentOrder() {
            StudentOrder so = new StudentOrder();
            return so;
        }

        static AnswerCityRegister checkCityRegister(StudentOrder so) {
            CityRegisterValidator crv1 = new CityRegisterValidator();
            crv1.hostName = "Host1";
//            crv1.login = "Login1";
//            crv1.password = "Pass1";
            AnswerCityRegister ans1 = crv1.checkCityRegister(so);

//            CityRegisterValidator crv2 = new CityRegisterValidator();
//            crv2.hostName = "Host2";
//            crv2.login = "Login2";
//            crv2.password = "Pass2";
//            AnswerCityRegister ans2 = crv2.checkCityRegister(so);
            return ans1;
        }

        static AnswerWedding checkWedding(StudentOrder so) {
            WeddingValidator wd = new WeddingValidator();
            return WeddingValidator.checkWedding(so);
        }

        static AnswerChildren checkChildren(StudentOrder so) {
            ChildrenValidator cv = new ChildrenValidator();
            return ChildrenValidator.checkChildren(so);
        }

        static AnswerStudent checkStudent(StudentOrder so) {
            StudentValidator sv = new StudentValidator();
            return StudentValidator.checkStudent(so);
        }

        static void sendMail(StudentOrder so) {
            new MailSender().sendMail(so);
        }
    }
}
