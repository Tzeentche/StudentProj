package edu.javacourse.studentProj.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() {
        System.out.println("START UP");
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