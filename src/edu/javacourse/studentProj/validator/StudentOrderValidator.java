package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.SaveStudentOrder;
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
                StudentOrder[] soArray = readStudentOrder();

                for(int c = 0; c < soArray.length; c++) {
                    System.out.println();
                    checkOneOrder(soArray[c]);
                }

                for(StudentOrder so : soArray) {
                    System.out.println();
                    checkOneOrder(so);
                }
            }

    public StudentOrder[] readStudentOrder() {
            StudentOrder[] soArray = new StudentOrder[3];

            for(int c = 0; c < soArray.length; c++) {
                soArray[c] = SaveStudentOrder.buildStudentOrder(c);
            }

            StudentOrder so = new StudentOrder();
            return soArray;
        }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);

        AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childrenAnswer = checkChildren(so);
        AnswerStudent studentAnswer = checkStudent(so);

        sendMail(so);
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