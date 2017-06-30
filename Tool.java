
/**
 * Tool is abstract class, superclass for 'ElectricTool' and 'HandTool' and subclass of 'ShopItem'. 
 * This class defines fields like timesBorrowed, onLoan, weight and can print them out.
 * Method increaseTimesBorrowed() increase field 'timesBorrowed' in one.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 20.03.2017)
 */

import java.io.*;
import java.awt.*;
import java.util.*;
public abstract class Tool extends ShopItem
{
    private int timesBorrowed, weight;
    private boolean onLoan;

    /**
     * This constructor is calling superclass constructor that is empty too. To put value to the field use extractData() from 'Shop' class.
     */
    public Tool()
    {
        super();
    }

    public Tool( int timesBorrowed, boolean onLoan, String itemName,String itemCode, int cost, int weight)
    {
        super( itemName, itemCode,  cost);
        this.timesBorrowed=timesBorrowed;
        this.weight=weight;
        this.onLoan=onLoan;
    }

    public void extractData(Scanner sc1)
    {
        timesBorrowed = sc1.nextInt();
        // System.out.println(timesBorrowed);
        onLoan = sc1.nextBoolean();
        // System.out.println(onLoan);
        super.extractData(sc1);
        weight = sc1.nextInt(); 
        //  System.out.println(weight);

    }

    /*
     * Print details about fields itemName, itemCode and cost from superclass 'ShopItem'
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n","timesBorrowed: " , timesBorrowed);
        System.out.printf("%-25s %-20s\n","onLoan: " , onLoan);
        System.out.printf("%-25s %-20s\n","weight: " , weight);
    }


    public boolean getOnLoan()
    {
        return onLoan;
    }

    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }

    public void setOnLoan (boolean value)
    {
        onLoan = value;
    }

    public void increaseTimesBorrowed()
    {
        timesBorrowed++;
    }




}
