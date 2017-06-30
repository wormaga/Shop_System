
/**
 * Abstract class Accessory stores field position.
 * Method printDetails() prints out the information about field position;
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 20.03.2017)
 */
import java.util.Scanner;
public abstract class Accessory extends ShopItem
{
    String position;
    /*
     * To put value to the field use extractData() from 'Shop' class.
     */
    public Accessory()
    {}
   
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n", "position: ", position);
    }
    
    public void extractData(Scanner sc1)
    {
      
        position = sc1.next().trim();
        // System.out.println(position);
        super.extractData(sc1);
    }
    public String getPosition()
    {
        return position;
    }
    public void setPosittion (String value) 
    {
        position = value;
    }
}
