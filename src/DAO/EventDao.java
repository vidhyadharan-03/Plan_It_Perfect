package DAO;

import Model.Event;
import dbConnection.DatabaseConnection;

import java.sql.*;

public class EventDao {
    public static int addEvent(Event eve) throws SQLException
    {
        String query ="INSERT INTO Event (Event_id, Event_name, Location, price, capacity) VALUES (?, ?, ?, ?, ?)";
        Connection connect = DatabaseConnection.getConnect();
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setInt(1,eve.getEventId());
        pst.setString(2,eve.getEventName());
        pst.setString(3,eve.getEventLocation());
        pst.setInt(4,eve.getEventPrice());
        pst.setInt(5,eve.getEventCapacity());

       int row = pst.executeUpdate();
       return row;
    }
    public static void displayEvents() throws SQLException
    {
        String query = "Select * from event";
        Connection connect = DatabaseConnection.getConnect();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            System.out.println("Event Id : "+rs.getInt(1) );
            System.out.println("Event Name : "+rs.getString(2) );
            System.out.println("Location : "+rs.getString(3) );
            System.out.println("Price : Rs."+rs.getInt(4));
            System.out.println("Capacity : "+rs.getInt(5) );
            System.out.println("-----------------------------------------------------------");

        }


    }
    public static int checkSeat(int id) throws SQLException {
        //String query = "Insert into BookingTable values(?,?,?,?,?,?)";
        String checkCapQuery = "SELECT capacity FROM event WHERE event_id = ?";
        Connection connect = DatabaseConnection.getConnect();
        PreparedStatement pst = connect.prepareStatement(checkCapQuery);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int data = rs.getInt(1);
            return data;
        } else {
            throw new SQLException("Event ID not found");
        }

    }
    public static void updateSeat(int id,int data,int capacity) throws SQLException
    {
        String updateQuery = "UPDATE event SET capacity = ? WHERE Event_id = ?";
        Connection connect = DatabaseConnection.getConnect();
        PreparedStatement pst = connect.prepareStatement(updateQuery);
        pst.setInt(1, data - capacity);
        pst.setInt(2, id);
        pst.executeUpdate();

    }


}
