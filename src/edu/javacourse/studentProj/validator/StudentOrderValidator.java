package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.mail.MailSender;
import edu.javacourse.studentProj.validator.ChildrenValidator;
import edu.javacourse.studentProj.validator.CityRegisterValidator;
import edu.javacourse.studentProj.validator.StudentValidator;
import edu.javacourse.studentProj.validator.WeddingValidator;


public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {

        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

        public void checkAll() {
            while(true) {
                StudentOrder so = readStudentOrder();
                System.out.println("Start");
                if (so == null) {
                    break;
                }

                System.out.println("Finish");

                AnswerCityRegister cityAnswer = checkCityRegister(so);
                if (!cityAnswer.success) {

                    break;
                }

                AnswerWedding wedAnswer = checkWedding(so);
                AnswerChildren childrenAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
            }
        }

    public StudentOrder readStudentOrder() {
            StudentOrder so = new StudentOrder();
            return so;
        }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
            return cityRegisterVal.checkCityRegister(so);
        }

    public AnswerWedding checkWedding(StudentOrder so) {
            return weddingVal.checkWedding(so);
        }

    public AnswerChildren checkChildren(StudentOrder so) {
            return  childrenVal.checkChildren(so);
        }

    public AnswerStudent checkStudent(StudentOrder so) {
            return studentVal.checkStudent(so);
        }

    public void sendMail(StudentOrder so) {
            new MailSender().sendMail(so);
        }
}