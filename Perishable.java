
/**
 * Perishable class that can make Perishable objects. 
 * It defines fields isIrritant, useByDate, volume.
 * Method printDetails() print info about these fields.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 08.03.2017)
 */
import java.util.Scanner;
public class Perishable extends Accessory
{
   private boolean isIrritant;
   private String useByDate;
   int volume;

    /**
     * Constructer calls superclass' (Accessory) constructor that is not definenig fields too.
     * To define fields use method extractData() in 'Shop' class
     */
    public Perishable()
    {
        super();
    }
    public void extractData(Scanner sc1)
    {
        isIrritant = sc1.nextBoolean();
        // System.out.println(isIrritant);
        useByDate = sc1.next().trim();
        // System.out.println(useByDate);
        volume = sc1.nextInt();
        //  System.out.println(volume);
        super.extractData(sc1);
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n","isIrritant: " , isIrritant);
        System.out.printf("%-25s %-20s\n","useByDate: " , useByDate);
        System.out.printf("%-25s %-20s\n","volume: " , volume);
    }
    
    public boolean getIsIrritant()
    {
        return isIrritant;
    }
    public String getUseByDate()
    {
        return useByDate;
    }
    public int getVolume()
    {
        return volume;
    }
    public void setVolume (int value)
    {
        volume = value;
    }
    public void setIsIrritant(boolean value)
    {
        isIrritant = value;
    }
}
