package DAO;

import Model.Booking;
import dbConnection.DatabaseConnection;

import java.sql.*;

public class BookingDao {
    public static void bookSeat(Booking bk)throws SQLException
    {
        String query = "Insert into BookingTable(event_id,Stu_id,Stu_name,college,event_name,seats_booked) values(?,?,?,?,?,?)";
        Connection connect = DatabaseConnection.getConnect();
        PreparedStatement pst = connect.prepareStatement(query);
       pst.setInt(1,bk.getEventId());
       pst.setInt(2,bk.getUserId());
       pst.setString(3,bk.getUserName());
       pst.setString(4,bk.getCollegeName());
       pst.setString(5,bk.getEventName());
      pst.setInt(6,bk.getSeats());
       pst.executeUpdate();

    }
    public static void showSpecificBooking(int user_id)
    {
        String query = "Select event_id , event_name, seats_booked from BookingTable where Stu_id=?";
        try(Connection connect = DatabaseConnection.getConnect())
        {
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setInt(1,user_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.print("Event Id : "+rs.getInt(1)+"    ");
            System.out.print("Event Name : "+rs.getString(2)+"   ");
            System.out.print("Seats Booked : "+rs.getInt(3));
        }catch(SQLException e)
        {
            System.out.println(e);

        }
    }
}
