package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.AnswerStudent;
import edu.javacourse.studentProj.domain.StudentOrder;

public class StudentValidator {

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student check is running");
        return new AnswerStudent();
    }
}
