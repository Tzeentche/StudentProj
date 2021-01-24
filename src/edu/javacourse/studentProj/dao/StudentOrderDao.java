package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.StudentOrder;
import edu.javacourse.studentProj.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {

    Long saveStudentOrder(StudentOrder so) throws DaoException;
    List<StudentOrder> getStudentOrders() throws DaoException;
}
