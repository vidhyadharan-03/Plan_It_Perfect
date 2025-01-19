
import java.util.*;

import DAO.*;
import Model.*;
import Services.BookEvent;
import Services.LoginValidation;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sign up");
        System.out.println("2.Sign in");
        String choice =scan.nextLine();

       switch (Integer.parseInt(choice))
        {
            case 1:
                System.out.print("Enter your College roll no last Four Digits :");
                String id = scan.nextLine();
                System.out.println();
                System.out.print("Enter Your Name : ");
                String name = scan.nextLine();
                System.out.println();
                System.out.print("Enter Your College Name : ");
                String collegeName = scan.nextLine();
                System.out.println();
                System.out.println("Enter Your Department : ");
                String Department = scan.nextLine();

                Users person = new Users(Integer.parseInt(id),name,collegeName,Department);
                UserDao.insertData(person);
                scan.close();
                break;
            case 2 :

                System.out.print("Enter your College roll no last Four Digits :");
                String idCheck = scan.nextLine();
                System.out.println();
                System.out.print("Enter Your Name : ");
                String nameCheck = scan.nextLine();
                System.out.println();
                System.out.print("Enter Your College Name : ");
                String collegeNameCheck = scan.nextLine();
                System.out.println();


                LoginValidation lv = new LoginValidation(Integer.parseInt(idCheck),nameCheck,collegeNameCheck);
                //boolean flag = lv.validationOfLogin();
                if(lv.validationOfLogin())
                {
                    System.out.println("Successully Loged in");
                    System.out.println();
                    System.out.println("------------------------------ Welcome to Event Mangament Company -----------------------------------------");

                    System.out.println("1.Add Events");
                    System.out.println("2. Coming Events");
                    System.out.println("3.Book your Seat");
                    System.out.println("4.View Profile");
                    String choose = scan.nextLine();
                    switch(Integer.parseInt(choose))
                    {
                        case 1 :
                            System.out.print("Enter your Event Id : ");
                            String eventId = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Your Event Name : ");
                            String eventName = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Your Location of the Event : ");
                            String eventLocation = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Price : ");
                            String eventPrice = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Event Seating Capacity : ");
                            String eventCapacity = scan.nextLine();
                            System.out.println();

                            Event eve = new Event(Integer.parseInt(eventId),eventName,eventLocation,Integer.parseInt(eventPrice),Integer.parseInt(eventCapacity));
                            int row = EventDao.addEvent(eve);
                            if(row==1)
                            {
                                System.out.println("Event Added Successfully!!");
                            }
                            else {
                                System.out.println("There is some failure");
                            }
                            break;
                        case 2 :
                               EventDao.displayEvents();
                               break;
                        case 3 :
                            System.out.print("Enter Your ID : ");
                            String stu_id = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter the Event Id : ");
                            String event_id = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Your Name : ");
                            String uName = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Event Name : ");
                            String event_name = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter Your College Name");
                            String college_name = scan.nextLine();
                            System.out.println();
                            System.out.print("Enter No of Seats");
                            String seat = scan.nextLine();
                            System.out.println();


                            Booking book = new Booking(Integer.parseInt(event_id),Integer.parseInt(stu_id),uName,event_name,college_name,Integer.parseInt(seat));
                            boolean isValid = BookEvent.booking(book);
                            if(isValid)
                            {
                                System.out.println("Seats has been booked Successfully!! Enjoy your Time");
                            }
                            else {
                                System.out.println("Oops Seats Gets full!! Better Luck next Time.");
                            }
                        case 4 :
                            UserDao.displayData(Integer.parseInt(idCheck));
                            System.out.print("Do you want to update your Profile ? Click Yes for Updation : ");
                            String yesOrNo = scan.nextLine();
                            //System.out.println();
                            if(yesOrNo.equalsIgnoreCase("Yes"))
                            {
                                System.out.print("Enter Your New Name :");
                                String changingName = scan.nextLine();
                                System.out.println();
                                System.out.print("Enter Your New College Name : ");
                                String changingCollegeName = scan.nextLine();
                                System.out.println();
                                System.out.println("Enter Your New Department Name : ");
                                String changingDepartmentName = scan.nextLine();
                                System.out.println();
                                System.out.print("Click Ok for Confirm : ");
                                String confirmMessage = scan.nextLine();
                                if(confirmMessage.equalsIgnoreCase("Ok")) {
                                    UserDao.updateProfile(changingName, changingCollegeName, changingDepartmentName, Integer.parseInt(idCheck));
                                }

                            }
                    }

                }
                else {
                    System.out.print("Login failed ! ");
                }
                scan.close();
               break;
            default:
                System.out.print("Invalid Option Clicked");

       }
    }
}