package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.StudentOrder;
import edu.javacourse.studentProj.exception.DaoException;

public interface StudentOrderDao {

    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
