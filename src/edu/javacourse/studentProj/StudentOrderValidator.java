package edu.javacourse.studentProj;

import edu.javacourse.studentProj.dao.StudentOrderDaoImpl;
//import edu.javacourse.studentProj.domain.children.AnswerChildren;
import edu.javacourse.studentProj.domain.register.AnswerCityRegister;
//import edu.javacourse.studentProj.domain.student.AnswerStudent;
//import edu.javacourse.studentProj.domain.wedding.AnswerWedding;
import edu.javacourse.studentProj.dao.StudentOrderDaoImpl;
import edu.javacourse.studentProj.domain.StudentOrder;
import edu.javacourse.studentProj.exception.DaoException;
import edu.javacourse.studentProj.mail.MailSender;
import edu.javacourse.studentProj.validator.ChildrenValidator;
import edu.javacourse.studentProj.validator.CityRegisterValidator;
import edu.javacourse.studentProj.validator.StudentValidator;
import edu.javacourse.studentProj.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator
{
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
        try {
            List<StudentOrder> soList = readStudentOrders();

            for (StudentOrder so : soList) {
                checkOneOrder(so);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StudentOrder> readStudentOrders() throws DaoException {
        List<StudentOrder> soList = new LinkedList<>();

        for (int c = 0; c < 5; c++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(c);
            soList.add(so);
        }
        return soList;
//        return new StudentOrderDaoImpl().getStudentOrders();
    }

    public void checkOneOrder(StudentOrder so) {
//        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//
//        sendMail(so);
    }
//
//    public AnswerCityRegister checkCityRegister(StudentOrder so) {
//        return cityRegisterVal.checkCityRegister(so);
//    }
//
//    public AnswerWedding checkWedding(StudentOrder so) {
//        return weddingVal.checkWedding(so);
//    }
//
//    public AnswerChildren checkChildren(StudentOrder so) {
//        return childrenVal.checkChildren(so);
//    }
//
//    public AnswerStudent checkStudent(StudentOrder so) {
//        return studentVal.checkStudent(so);
//    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}