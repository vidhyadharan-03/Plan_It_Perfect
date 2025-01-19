package Model;

public class Booking {
    private  int eventId;
    private int userId;
    private String userName;
    private String eventName;
    private String collegeName;
    private int seats;

   public Booking(int ei,int ui,String un,String en,String cn,int st)
    {
        this.eventId = ei;
        this.userId = ui;
        this.userName=un;
        this.eventName=en;
        this.collegeName=cn;
        this.seats = st;
    }
    public  int getEventId()
    {
        return eventId;
    }
    public  int getUserId()
    {
        return userId;
    }
    public  String getUserName()
    {
        return userName;
    }
    public  String getEventName()
    {
        return eventName;
    }
    public String getCollegeName() {
        return collegeName;
    }

    public int getSeats() {
        return seats;
    }
    

}
