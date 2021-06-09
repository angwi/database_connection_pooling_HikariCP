package hikariapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HikariApp {

    public static void main(String[] args) {
        try (Connection connection = DBUtil.getDataSource().getConnection(); Statement st = connection.createStatement();) {

            String SQL = "SELECT *FROM employees WHERE first_name IS NOT NULL";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int empId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");

                System.out.println(empId + "\t" + firstName + "\t" + lastName + "\t" + email + "\t" + phone + "\t" + gender);
            }
        } catch (Exception e) {
        }
    }

}
