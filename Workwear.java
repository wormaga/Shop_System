
/**
 * Workwear class that can make Workwear objects. It defines fields manStandsrd, colour and size. 
 * Method printDetails() print info about these fields.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 08.03.2017)
 */
import java.util.Scanner;
public class Workwear extends Accessory
{
    String manStandard, colour, size;

    /**
     * Constructer calls superclass' (Accessory) constructor that is not definenig fields too.
     * To define fields use method extractData() in 'Shop' class
     */
    public Workwear()
    {
        super(); 
    }

    public void extractData(Scanner sc1)
    {
       
        manStandard = sc1.next().trim();
        // System.out.println(manStandard);
        colour = sc1.next().trim();
        // System.out.println(colour);
        size = sc1.next().trim();
        //  System.out.println(size);
       super.extractData(sc1);
    }
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n","Manufactoring Standard: " , manStandard);
        System.out.printf("%-25s %-20s\n","colour: " , colour);
        System.out.printf("%-25s %-20s\n","size: " , size);
    }
    
    
    public String getManStandartd()
    {
        return manStandard;
    }
    
    public String getColour()
    {
        return colour;
    }
    
    public String getSize()
    {
        return size;
    }
    
    public void setSize(String value)
    {
        size = value;
    }
    
    
}
