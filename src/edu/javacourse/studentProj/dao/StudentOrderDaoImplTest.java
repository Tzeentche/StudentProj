package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.*;
import edu.javacourse.studentProj.exception.DaoException;
import org.junit.*;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.nio.file.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startUp() throws SQLException, IOException, ConnectException, Exception {
        URL url1 = StudentOrderDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");
        URL url2 = StudentOrderDaoImplTest.class.getClassLoader()
                .getResource("student_data.sql");

        List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
        String sql1 = str1.stream().collect((Collectors.joining()));

        List<String> str2 = Files.readAllLines(Paths.get(url2.toURI()));
        String sql2 = str2.stream().collect((Collectors.joining()));

        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt1 = con.createStatement();) {

            stmt1.executeUpdate(sql1);
            stmt1.executeUpdate(sql2);
        }
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

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test
    public void getStudentOrder() {

    }

    public StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro1 = new RegisterOffice(1L, " ", " ");
        so.setMarriageOffice(ro1);

        Street street = new Street(1L, "First str.");
        Address address = new Address("195000", street, "12", "", "142");

//        HUSBAND
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("HH12345");

        //        WIFE
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("WW12345");

        //        CHILD1
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setSertificateNumber("" + (3000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(2L, " ", " ");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);

        //        CHILD2
        Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
        child1.setSertificateNumber("" + (4000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(1L, " ", " ");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
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