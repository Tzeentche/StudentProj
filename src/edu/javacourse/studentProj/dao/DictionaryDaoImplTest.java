package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.exception.DaoException;
import org.junit.*;

import java.io.IOException;
import java.net.*;
import java.nio.file.*;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void testStreet() throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(d.size() == 3);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010020000000");
        Assert.assertTrue(ro.size() == 3);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);
    }

    @Before
    public void startTest() {
        System.out.println("START TEST");
    }

    @Test
    public void TestExample1() {
        System.out.println("TEST 1");
    }

    @Test
    @Ignore
    public void TestExample2() {
        System.out.println("TEST 2");
    }

    @Test
    public void TestExample3() {
        System.out.println("TEST 3");
        throw new RuntimeException("Bad Result");
    }
}