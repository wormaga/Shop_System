import java.util.Scanner;
/**
 * This class creates HandTool object and can print all details about itself (fields sharpenable.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 08.03.2017)
 */
public class HandTool extends Tool
{
    private boolean sharpenable;

    /**
     * Constructer calls superclass' (Tool) constructor that is not definenig fields too.
     * To define fields use method extractData() in 'Shop' class
     * 
     */
    public HandTool()
    {
        super();
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-25s %-20s\n","sharpenable: " , sharpenable);
    }
    
    public boolean getSharpenable()
    {
        return sharpenable;
    }
    
    public void extractData(Scanner sc1)
    {
        sharpenable =  sc1.nextBoolean();
        super.extractData(sc1);
    }
}//end of the class
