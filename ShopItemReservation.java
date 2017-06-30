
/**
 * Write a description of class ShopItemReservation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import java.lang.*;
public class ShopItemReservation
{
    // instance variables - replace the example below with your own
    private String reservationNo, itemID, customerID;
    private Date startDate;
    private int noOfDays;

    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {

        this.reservationNo = reservationNo; 
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = new DateUtil().convertStringToDate(startDate)  ;
        this.noOfDays =noOfDays;

    }

    public ShopItemReservation() 
    {

    }

    public void printDetails()
    {
        
        System.out.printf("%-25s %-20s\n","Reservation number:" ,reservationNo );
        System.out.printf("%-25s %-20s\n","Customer ID:" ,customerID );
        System.out.printf("%-25s %-20s\n","Item code:" ,itemID );
        System.out.printf("%-25s %-20s\n","Start date:" ,DateUtil.convertDateToShortString(startDate) );
        System.out.printf("%-25s %-20s\n\n","Number of days:" ,noOfDays );
    }
    
    public void writeData(PrintWriter pwriter)
    {
        String d = ","; //delimeter for writing info in a file
        pwriter.println(reservationNo+d+itemID+d+customerID+d+DateUtil.convertDateToShortString(startDate)+d+noOfDays);
    }
    
    public void readData(Scanner sc1)
    {
        reservationNo = sc1.next().trim();
        // System.out.println(reservationNo);
        itemID = sc1.next().trim();
        // System.out.println(itemID);
        customerID = sc1.next().trim();
        // System.out.println(customerID);
        startDate = DateUtil.convertStringToDate(sc1.next().trim());
        // System.out.println(DateUtil.convertDateToShortString(startDate));
        noOfDays = sc1.nextInt();
        // System.out.println(noOfDays);
    }
    
    public Date getStartDate()
    {
        return startDate;
    }

    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    public String getItemID()
    {
        return itemID;
    }
    
    public String toString()
    {
        return "ResNo:"+reservationNo+" Item:"+ itemID +" Customer:"+ customerID;
    }
}
