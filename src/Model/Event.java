package Model;

public class Event {
    private int eventId=0;
    private String eventName = " ";
    private String location = " ";
    private int price = 0;
    private int capacity =0;

   public Event(int ei,String en,String lo,int cost,int space)
    {
        this.eventId=ei;
        this.eventName=en;
        this.location = lo;
        this.price=cost;
        this.capacity=space;
    }
    public int getEventId()
    {
        return eventId;
    }
    public String getEventName()
    {
        return eventName;
    }
    public String getEventLocation()
    {
        return location;
    }
    public int getEventPrice()
    {
        return price;
    }
    public int getEventCapacity()
    {
        return capacity;
    }





}
