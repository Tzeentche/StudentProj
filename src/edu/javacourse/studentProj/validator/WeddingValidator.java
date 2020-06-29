package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.AnswerWedding;
import edu.javacourse.studentProj.domain.StudentOrder;

public class WeddingValidator {

    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding check is running");
        return new AnswerWedding();
    }
}
