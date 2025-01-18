package DAO;

import Model.Users;
import dbConnection.DatabaseConnection;

import java.sql.*;

public class UserDao {



    public static void displayData()
    {
        String query = "Select * from Users";
        try {
            Connection connect = DatabaseConnection.getConnect();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println("-------------------User Detials -----------------");
                System.out.println("Student Id : "+rs.getInt(1));
                System.out.println("Name : "+rs.getNString(2));
                System.out.println("College : "+rs.getNString(3));
                System.out.println("Department : "+rs.getNString(4));
            }


        }catch(SQLException s) {
            System.out.print("Error Occur");
        }
    }

    public static void insertData(Users per)
    {
        String query = "Insert into Users values(?,?,?,?)";
        try {
            Connection connect = DatabaseConnection.getConnect();
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1,per.getId());
            ps.setString(2,per.getName());
            ps.setString(3,per.getCollege());
            ps.setString(4, per.getDepartment());
            int flag = ps.executeUpdate();

            if(flag==1)
            {
                System.out.println("Account Created ");

            }
            else {
                System.out.print("Verify the Detials once again!");
            }

        }catch (SQLException s)
        {
            System.out.println(s);
        }

    }

    public static ResultSet displayUniqueData(int id)throws SQLException
    {
        String query = "Select * from Users where Stu_id="+id;

            Connection connect = DatabaseConnection.getConnect();
            Statement st = connect.createStatement();
        return st.executeQuery(query);
    }











}
