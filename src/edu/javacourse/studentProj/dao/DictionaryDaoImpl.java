package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.config.Config;
import edu.javacourse.studentProj.domain.Street;
import edu.javacourse.studentProj.exception.DaoException;

import java.sql.*;
import java.util.*;

public class DictionaryDaoImpl implements DictionaryDao {

    private static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM jc_streets WHERE UPPER(street_name) LIKE UPPER (?)";

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }

    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_STREET)) {

                stmt.setString(1, "%" + pattern + "%");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                    result.add(str);
            }
        }catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }
}
