package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.SaveStudentOrder;
import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.validator.register.AnswerCityRegister;
import edu.javacourse.studentProj.mail.MailSender;

import java.util.LinkedList;
import java.util.List;


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
                List<StudentOrder> soList = readStudentOrder();

                for(StudentOrder so : soList) {
                    System.out.println();
                    checkOneOrder(so);
                }
            }

    public List<StudentOrder> readStudentOrder() {
            List<StudentOrder> soList = new LinkedList<>();

            for(int c = 0; c < 5; c++) {
                StudentOrder so = SaveStudentOrder.buildStudentOrder(c);
                soList.add(so);
            }

            StudentOrder so = new StudentOrder();
            return soList;
        }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childrenAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//
//        sendMail(so);
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