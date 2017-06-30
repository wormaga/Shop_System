
/**
 * This class creates ElectricTool and can print all details about itself.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 08.03.201
 */
import java.util.Scanner;
public class ElectricTool extends Tool
{
    private String power;
    private boolean rechargeable;

    /**
     * Constructer calls superclass' (Tool) constructor that is not definenig fields too.
     * To define fields use method extractData() in 'Shop' class
     */
    public ElectricTool()
    {
        super();
    }

    public ElectricTool(boolean rechargeable, String power, int timesBorrowed, boolean onLoan, String itemName,String itemCode, int cost, int weight)
    {
        super(timesBorrowed,  onLoan,  itemName, itemCode,  cost,  weight);
        this.power=power;
        this.rechargeable = rechargeable;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n","power: " , power);
        System.out.printf("%-25s %-20s\n", "rechargeable: " , rechargeable);
    }

    public String getPower()
    {
        return power;
    }

    public boolean getReechargeable()
    {
        return rechargeable;
    }

    public void extractData(Scanner sc1)
    {
        rechargeable =  sc1.nextBoolean();
        power = sc1.next().trim();
        super.extractData(sc1);

    }


}//end of the class