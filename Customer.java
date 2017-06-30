
/**
 * Customer class has 2 constructors, one is empty (for reading data) second - with all parametrs. Method printDetails() print all info about customers in 2 columns.
 * You can read data with readData() method that has parametr Scanner object (it reads line from file)
 * 
 * 
 * @author (Aleksandrs Konopackis)
 * @version (v1 23.03.2017)
 */
import java.io.PrintWriter;
import java.util.Scanner;
public class Customer
{
    private String customerID, surname, firstName, otherInitials, title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        this.customerID="unknown";
        this.surname=surname;
        this.firstName=firstName;
        this.otherInitials=otherInitials;
        this.title=title;
    }

    public Customer()
    {

    };

    public void printDetails()
    {
        System.out.printf("%-25s %-20s\n","Customer ID: " , customerID);
        String space;
        if (otherInitials.equals(""))  space="";
               else space=" ";
        System.out.printf("%-25s %-20s\n\n", "name", title+" "+firstName+" "+otherInitials+space+surname);
        //         System.out.printf("%-25s %-20s\n","Title:", title);
        //         System.out.printf("%-25s %-20s\n", "First name:",firstName);
        //         System.out.printf("%-25s %-20s\n", "Surname:", surname);
        //         System.out.printf("%-25s %-20s\n\n", "Other Initials:", otherInitials);
    }

    public void readData(Scanner sc1)
    {
        customerID = sc1.next().trim();
        // System.out.println(customerID);
        surname = sc1.next().trim();
        // System.out.println(surname);
        firstName = sc1.next().trim();
        // System.out.println(firstName);3
        otherInitials = sc1.next().trim();
        // System.out.println(otherInitials);
        title = sc1.next().trim();
        // System.out.println(title);
    }

    public void writeData(PrintWriter pwriter)
    {
        String d = ","; //delimeter for writing info in a file
        pwriter.println(customerID+d+surname+d+firstName+d+otherInitials+d+title);
    }
    
    public String getCustomerID()
    {
        return customerID;
    }

    public String getSurname ()
    {
        return surname;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public String getTitle()
    {
        return title;
    }
    public String getOtherInitials ()
    {
        return otherInitials;
    }

    public void setOtherInitials (String value)
    {
        otherInitials=value;
    }

    public void setCustomerID(String value)
    {
        customerID=value;
    }
}
