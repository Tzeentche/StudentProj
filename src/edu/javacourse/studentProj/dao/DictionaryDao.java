package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.CountryArea;
import edu.javacourse.studentProj.domain.PassportOffice;
import edu.javacourse.studentProj.domain.RegisterOffice;
import edu.javacourse.studentProj.domain.Street;
import edu.javacourse.studentProj.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;
}
