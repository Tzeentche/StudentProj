package edu.javacourse.studentProj.dao;

import edu.javacourse.studentProj.config.Config;
import edu.javacourse.studentProj.domain.Street;
import edu.javacourse.studentProj.domain.StudentOrder;
import edu.javacourse.studentProj.domain.StudentOrderStatus;
import edu.javacourse.studentProj.exception.DaoException;

import java.sql.*;

public class StudentDaoImpl implements StudentOrderDao {

    private static final String INSERT_ORDER =
            "INSERT INTO public.jc_student_orders(" +
            "student_order_status, student_order_date, h_sur_name, " +
                    "h_given_name, h_patronymic, h_date_of_birth, h_passport_serial, h_passport_number, h_passport_date, " +
                    "h_passport_office_id, h_post_index, h_street_code, h_building, h_extention, h_apartment, " +
                    "w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_serial, w_passport_number, w_passport_date, " +
                    "w_passport_office_id, w_post_index, w_street_code, w_building, w_extention, w_apartment, certificate_id, " +
                    "register_office_id, marriage_date)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER)) {

            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(3, so.getHusband().getSurname());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));

        }catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}
