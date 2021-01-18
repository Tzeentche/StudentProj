package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.Street;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreet(String pattern)
}
