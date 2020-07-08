package edu.javacourse.studentProj.validator;

import edu.javacourse.studentProj.domain.Adult;
import edu.javacourse.studentProj.domain.Child;
import edu.javacourse.studentProj.domain.register.CityRegisterResponse;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;
import edu.javacourse.studentProj.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker{

    public static final String GOOD1 = "1000";
    public static final String GOOD2 = "2000";
    public static final String BAD1 = "1001";
    public static final String BAD2 = "2001";
    public static final String ERR1 = "1002";
    public static final String ERR2 = "2002";
    public static final String ERR_T_1 = "1003";
    public static final String ERR_T_2 = "2003";

    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {

        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult) {
            Adult t = (Adult) person;
            String ps = t.getPasportSeria();
            if (ps.equals(GOOD1) || ps.equals(GOOD2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }

            if (ps.equals(BAD1) || ps.equals(BAD2)) {
                res.setExisting(false);
            }

            if (ps.equals(ERR1) || ps.equals(ERR2)) {
                CityRegisterException ex = new CityRegisterException("1","GRN ERROR" + ps);
                throw ex;
            }

            if (ps.equals(ERR_T_1) || ps.equals(ERR_T_2)) {
                TransportException ex = new TransportException("transport ERROR" + ps);
                throw ex;
            }
        }

        if(person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }

        System.out.println(res);
        return res;
    }
}
