
/**
 * The class "ShopItem" is super class for 'Tool' and 'Accessory' and supersuper class for 'HandTool', 'ElectricTool', 'Workwear' and 'Perishable'.
 * This class is storing name,code and cost of each item. It is possible to print details for these fields.
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v1 20.03.2017)
 */
import java.util.Scanner;
public abstract class ShopItem
{
    private String itemName, itemCode;
    private int cost;

    /**
     * Constructor for objects of class ShopItem
     */
    public ShopItem()
    {
        
    }
    
    public ShopItem(String itemName,String itemCode, int cost)
    {
        this.itemName=itemName;
        this.itemCode=itemCode;
        this.cost=cost;
    }
    public void extractData(Scanner sc1)
    {
        
        itemName = sc1.next().trim();
           // System.out.println(itemName);
        itemCode = sc1.next().trim();
           // System.out.println(itemCode);
        cost = sc1.nextInt(); 
          //  System.out.println(cost);
        

    }

    public void printDetails()
    {
        System.out.printf("\n%-25s %-20s\n", "itemName: ", itemName);
        System.out.printf("%-25s %-20s\n","itemCode: " ,itemCode);
        System.out.printf("%-25s %-20s\n","cost: " , cost);
    }
    
    public String getItemName()
    {
        return itemName;
    }

    public String getItemCode()
    {
        return itemCode;
    }
    public int getCost()
    {
        return cost;
    }
    public void setCost(int value)
    {
        cost=value;
    }
    public void setItemCode(String value)
    {
        itemCode = value;
    }
}