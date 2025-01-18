package Services;
import DAO.BookingDao;
import DAO.EventDao;
import Model.*;

import java.sql.SQLException;

public class BookEvent {


    public BookEvent()
    {

    }
    public static boolean booking(Booking bk) throws SQLException
    {
       int cap = EventDao.checkSeat(bk.getEventId());
       if(cap!=0 && (cap-bk.getSeats()>0))
       {
           BookingDao.bookSeat(bk);
           EventDao.updateSeat(bk.getEventId(),cap,bk.getSeats());
           return true;

       }
       return false;

    }
}
