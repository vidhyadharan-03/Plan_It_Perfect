package DAO;

import Model.Booking;
import dbConnection.DatabaseConnection;

import java.sql.*;

public class BookingDao {
    public static void bookSeat(Booking bk)throws SQLException
    {
        String query = "Insert into BookingTable(event_id,Stu_id,Stu_name,college,event_name) values(?,?,?,?,?)";
        Connection connect = DatabaseConnection.getConnect();
        PreparedStatement pst = connect.prepareStatement(query);
       pst.setInt(1,bk.getEventId());
       pst.setInt(2,bk.getUserId());
       pst.setString(3,bk.getUserName());
       pst.setString(4,bk.getCollegeName());
       pst.setString(5,bk.getEventName());
      // pst.setString(5,"Sucess");
       pst.executeUpdate();

    }
}
