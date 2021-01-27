package edu.javacourse.studentProj.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner {

    public static void main(String[] args) {
        SimpleRunner sr =  new SimpleRunner();

        sr.runTests();
    }

    private void runTests() {
        try {
            Class cl = Class.forName("edu.javacourse.studentProj.dao.DictionaryDaoImplTest");

            Constructor cst = cl.getConstructor();
            Object entity = cst.newInstance();

            Method[] meth = cl.getMethods();
            for(Method m : meth) {
                Test ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
