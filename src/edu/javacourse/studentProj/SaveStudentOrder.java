package edu.javacourse.studentProj;

import edu.javacourse.studentProj.domain.Address;
import edu.javacourse.studentProj.domain.Adult;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {

    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder:");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageSertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000", "Заневский пр.", "12", "", "142");

//        HUSBAND
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPasportSeria("" + (1000 + id));
        husband.setPasportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел милиции № " + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);

        //        WIFE
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPasportSeria("" + (2000 + id));
        wife.setPasportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел милиции № " + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        //        CHILD
        Adult child = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child.setPasportSeria("" + (3000 + id));
        child.setPasportNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018, 7, 19));
        child.setIssueDepartment("Отдел ЗАГС № " + id);
        child.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.setChild(child);
        return so;
    }
}
