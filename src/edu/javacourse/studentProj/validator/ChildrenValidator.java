package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.AnswerChildren;
import edu.javacourse.studentProj.domain.StudentOrder;

public class ChildrenValidator {

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
