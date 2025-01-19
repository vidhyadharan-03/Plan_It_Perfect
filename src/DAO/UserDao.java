package DAO;

import Model.Users;
import dbConnection.DatabaseConnection;

import java.sql.*;

public class UserDao {


    public static void displayData(int id) {
        String query = "Select * from Users where Stu_id=(?)";
        try {
            Connection connect = DatabaseConnection.getConnect();
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("-------------------User Detials -----------------");
                System.out.println("Student Id : " + rs.getInt(1));
                System.out.println("Name : " + rs.getNString(2));
                System.out.println("College : " + rs.getNString(3));
                System.out.println("Department : " + rs.getNString(4));
            }


        } catch (SQLException s) {
            System.out.print("Error Occur");
        }
    }

    public static void insertData(Users per) {
        String query = "Insert into Users values(?,?,?,?)";
        try {
            Connection connect = DatabaseConnection.getConnect();
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1, per.getId());
            ps.setString(2, per.getName());
            ps.setString(3, per.getCollege());
            ps.setString(4, per.getDepartment());
            int flag = ps.executeUpdate();

            if (flag == 1) {
                System.out.println("Account Created ");

            } else {
                System.out.print("Verify the Detials once again!");
            }

        } catch (SQLException s) {
            System.out.println(s);
        }

    }

    public static ResultSet displayUniqueData(int id) throws SQLException {
        String query = "Select * from Users where Stu_id=" + id;

        Connection connect = DatabaseConnection.getConnect();
        Statement st = connect.createStatement();
        return st.executeQuery(query);
    }

    public static void updateProfile(String name, String collegeName, String Department, int user_id) {
        String queryForUpdateName = "UPDATE Users SET User_Name = ? WHERE Stu_id = ?";
        String queryForCollegeName = "UPDATE Users SET College_name = ? WHERE Stu_id = ?";
        String queryForDeptName = "UPDATE Users SET Dept_name = ? WHERE Stu_id = ?";

        // Database connection
        try (Connection connect = DatabaseConnection.getConnect()) {
            // Disable auto-commit for batch processing
            connect.setAutoCommit(false);

            // Prepare the SQL queries using PreparedStatement
            try (PreparedStatement psUpdateName = connect.prepareStatement(queryForUpdateName);
                 PreparedStatement psUpdateCollegeName = connect.prepareStatement(queryForCollegeName);
                 PreparedStatement psUpdateDeptName = connect.prepareStatement(queryForDeptName)) {

                // Set parameters and add to batch for "Update Name"
                psUpdateName.setString(1, name); // Example User Name
                psUpdateName.setInt(2, user_id); // Example Student ID
                psUpdateName.addBatch();

                // Set parameters and add to batch for "Update College Name"
                psUpdateCollegeName.setString(1, collegeName); // Example College Name
                psUpdateCollegeName.setInt(2, user_id); // Example Student ID
                psUpdateCollegeName.addBatch();

                // Set parameters and add to batch for "Update Dept Name"
                psUpdateDeptName.setString(1, Department); // Example Dept Name
                psUpdateDeptName.setInt(2, user_id); // Example Student ID
                psUpdateDeptName.addBatch();

                // Execute the batch
                psUpdateName.executeBatch();
                psUpdateCollegeName.executeBatch();
                psUpdateDeptName.executeBatch();

                // Commit the transaction
                connect.commit();

                System.out.println("Changes Updated Successfully");
            } catch (SQLException e) {
                // Rollback the transaction in case of an error
                connect.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
