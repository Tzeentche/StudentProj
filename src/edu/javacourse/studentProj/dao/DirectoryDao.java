package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.domain.Street;

import java.sql.*;
import java.util.*;

public class DirectoryDao {

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
                "postgres", "postgres");
        return con;
    }

    public List<Street> findStreets(String pattern) throws Exception {

        List<Street> result = new LinkedList<>();
//        Class.forName("org.postgresql.Driver");

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT street_code, street_name " +
                "FROM jc_streets WHERE UPPER(street_name) LIKE UPPER ('%firs%')";
        ResultSet rs = stmt.executeQuery("SELECT * FROM jc_street");
        while (rs.next()) {
           Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
            result.add(str);
        }
        return result;
    }
}
