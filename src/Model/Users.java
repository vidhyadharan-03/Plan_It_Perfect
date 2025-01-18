package Model;

public class Users {
    private int id =0;
    private  String name=" ";
    private  String college=" ";
    private  String dept=" ";
    public Users(int i,String n,String c,String d)
    {
        this.id=i;
        this.name = n;
        this.college=c;
        this.dept = d;
    }

    public String getName()
    {
        return name;
    }
    public String getCollege()
    {
        return college;
    }
    public String getDepartment()
    {
        return dept;
    }
    public int getId()
    {
        return id;
    }




}
