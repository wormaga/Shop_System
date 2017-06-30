
/**
 * Test class has methods in custructor that are testing each step of project (part 3). 
 * To test any step of the project you need to comment out the appropriate method insdie the cunstrocter and read comment above the method (there are instruction how to make test).
 * 
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v2 28.03.2017)
 */
import java.util.Date;
public class Test
{
    // instance variables - replace the example below with your own
    private Shop shop;

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        //shop = new Shop("Alex_shop");
        //part3_step1();
        //part3_step2();
        //part3_step3();
        //part3_step4();
        //part3_step5();

        //part4_step1();
        //part4_step2();
        //part4_step3();
        //part4_step4();
        part4_step5();
    }

    /*
     * Testing method "convertStringToDate()" and "daysBetween()"
     */
    public void part4_step1()
    {
        String date1 = "14-02-2017";
        String date2 = "24-03-2017";
        Date date_1 = new DateUtil().convertStringToDate(date1);
        Date date_2 = new DateUtil().convertStringToDate(date2);

        System.out.println("Test on converting String to date and counting days between");
        System.out.println("Start date: "+date1);
        System.out.println("End date:   "+date2);
        System.out.print("days between: "+new DateUtil().daysBetween(date_1, date_2));

    }

    public void part4_step2()
    {
        //         /*
        //          * testing generating unique reservation number
        //          */
        //         System.out.printf("\fYou see 10 reservaton numbers\n");
        //         for (int i=0; i<10; i++)
        //             System.out.println(shop.generateReservationNo());

        //         /*
        //          * testing adding and retrieving shopItemReservation object from shopItemReservationMap
        //          * 
        //          */
        //         System.out.printf("\fI store shopItem in ItemReservationMap then retrieve it and print details\n");
        //         ShopItem newShopItem = new ElectricTool (true,"18V",12,false,"Test subject","RD2001",14995,1800);
        //         shop.addItem(newShopItem);
        //         Customer customer = new Customer("Konopackis","Alex","","Mr");
        //         customer.setCustomerID("GYM-87630");
        //         String reservationNo = shop.generateReservationNo();
        //         ShopItemReservation itemRes = new ShopItemReservation(reservationNo,"RD2001", "GYM-87630", "10-06-2017",10);
        //         shop.storeItemReservation(itemRes);
        //         
        //         ShopItemReservation newItemRes = shop.getItemReservation(reservationNo);
        //         newItemRes.printDetails();

        //         /*
        //          * Test on makeItemReservation checks
        //          */
        //         Customer customer = new Customer("Konopackis","Alex","","Mr");
        //         customer.setCustomerID("GYM-87630");
        //         shop.storeCustomer(customer);
        //         ShopItem item = new ElectricTool (true,"18V",12,false,"Test subject","RD2001",14995,1800);
        //         shop.addItem(item);
        //         
        //         System.out.printf("\fI put NOT valid customer ID - ZZZZ\n");
        //         shop.makeItemReservation("ZZZZ", "RD2001", "10-06-2017",10);
        //         System.out.printf("\nI put NOT valid item ID - RF98\n");
        //         shop.makeItemReservation("GYM-87630", "RF98", "10-06-2017",10);
        //         System.out.printf("\nI put NOT valid date - 98-06-2017\n");
        //         shop.makeItemReservation("GYM-87630", "RD2001", "98-06-2017",10);
        //         System.out.printf("\nI put NOT valid number of days - -89\n");
        //         shop.makeItemReservation("GYM-87630", "RD2001", "10-06-2017",-89);
        //         System.out.printf("\nEverything should be fine :)\n");
        //         shop.makeItemReservation("GYM-87630", "RD2001", "10-06-2017",10);

        //         /*
        //          * Test on printItemReservations()
        //          */
        //         System.out.printf("\fPrint empty list of reservation:\n");
        //         shop.printItemReservations();
        //         System.out.println("");
        // 
        //         System.out.println("Print reservation list with some objects:");
        //         for (int i=0; i<5; i++)
        //         {
        //             String reservationNo = shop.generateReservationNo();
        //             ShopItemReservation itemRes = new ShopItemReservation(reservationNo,"RD2001", "GYM-87630", "10-06-2017",10);
        //             shop.storeItemReservation(itemRes);
        //         }
        //         shop.printItemReservations();

        /*
         * Test on correct writing and reading Reservation data from file
         */
        System.out.printf("\f1) You need to choose to read file 'test1_writing.txt'"+
            "\n2) then type new name for storing reservation data"+
            "\n3) and now read just created file\n");

        shop.readItemReservationData();
        shop.writeItemReservationData();
        shop.readItemReservationData();
        shop.printItemReservations();
        System.out.println("if you see detail of 10 objects with reservation number from 69 to 73 --> it is correct");
    }

    public void part4_step3()
    {
        //         /*
        //          * Test that shows correct storeItemReservation() with addItemReservation() for Diary
        //          * and printDiaryEntries()
        //          */
        //         System.out.printf("\fYou have 1 reservation: start date:20-02-2018, days: 5\n"); 
        //         shop.printDiaryEntries("18-02-2018", "27-02-2018");

        //         /*
        //          * Test on making Reservation if item is booked for that time
        //          */
        //         System.out.printf("\fYou have 1 reservation: start date:20-02-2018, days: 5\n\n"); 
        //         System.out.println("You make reservation 15-02-2018 for 6 days");
        //         shop.makeItemReservation("AB-457628", "HT5623", "15-02-2018", 6);
        //         
        //         System.out.println("");
        //         System.out.println("You make reservation 26-02-2018 for 2 days");
        //         shop.makeItemReservation("AB-457628", "HT5623", "26-02-2018", 2);
        //         
        //         System.out.println("");
        //         System.out.println("Results:");
        //         shop.printDiaryEntries ("15-02-2018", "28-02-2018");

        /*
         * Test on deleteItemReservation()
         */
        System.out.printf("\fYou have 1 reservation: start date:20-02-2018, days: 5\n");
        System.out.println("This is list of reservation in Shop class");
        shop.printItemReservations();
        shop.printDiaryEntries ("19-02-2018", "25-02-2018");
        System.out.printf("\n\n\n\n");

        System.out.println("I delete that reservation and now:");
        ShopItemReservation itemRes = shop.getItemReservation("000075");
        shop.deleteItemReservation(itemRes);
        shop.printItemReservations();
        shop.printDiaryEntries ("19-02-2018", "25-02-2018");
    }

    public void part4_step4()
    {
        //         /*
        //          * Test on correct reloadSystem()
        //          */
        //         shop.printAllCustomers(); 
        //         System.out.println("==================================================");
        //         shop.printItemReservations();
        //         System.out.println("==================================================");
        //         shop.printItemDetails();

         /*
         * Test_2 on reloadSystem()
         */
        System.out.println("I add Customer Robert and Reservation 099999 and then reload System");
        Customer customer = new Customer("Roberts","John", "T", "Mr");
        shop.storeCustomer(customer);
          ShopItemReservation itemRes = new ShopItemReservation("099999","PI1320", "AB-457628", "10-06-2017",3);
          shop.storeItemReservation(itemRes);
          
       System.out.println("=============Before System reload=================");
       shop.printAllCustomers(); 
       System.out.println("--------------------------------------------------");
       shop.printItemReservations();
       System.out.println("==============After System reload=================");
       
       shop.reloadSystem();
       
       shop.printAllCustomers(); 
       System.out.println("--------------------------------------------------");
       shop.printItemReservations();
       
        
        //         /*
        //          * Test on closeDownSystem()
        //          */
        //         Customer customer = new Customer("Roberts","John", "T", "Mr");
        //         shop.storeCustomer(customer);
        //         
        //         ShopItemReservation itemRes = new ShopItemReservation("099999","PI1320", "AB-457628", "10-06-2017",3);
        //         shop.storeItemReservation(itemRes);
        //         
        //         shop.closeDownSystem();
        //         shop.reloadSystem();
        //         
        //         shop.printAllCustomers(); 
        //         System.out.println("==================================================");
        //         shop.printItemReservations();
        //         System.out.println("==================================================");
        //         //shop.printItemDetails();
        //         
        //         System.out.println("if you see Customer Robert and Reservation 0999999, then everything works");
    
       
    
    
    }

    
    public void part4_step5()
    {
        /*
         * Dont forget to comment shop in constructor
         */
       ShopWindow okno = new ShopWindow ();
        
    }
    
    
    /*
     * Test two constructor of Customer's class.
     * Test on reading customers info from file, storing customer object in customerMap and method printDetails().
     * Do NOT FORGET to choose the file "customers_data.txt" when you will be doing testing.
     */
    public void part3_step1()
    {
        Customer customer = new Customer("Roberts","John", "T", "Mr");
        shop.storeCustomer(customer);
        shop.printAllCustomers();

        shop.readCustomerData();
        System.out.printf("\f");
        shop.printAllCustomers();
    }

    /*
     * First you need to choose "customer_data.txt" to read original data;
     * Second time you choose "new_customer_data.txt" to read yourr written file with additional customer.
     * On the screen should be information about 5 customers.
     * 
     * Test on correct reading customer data, creating and adding new customer object, and writing data to file.
     */
    public void part3_step2()
    {
        shop.readCustomerData();
        Customer myCustomer = new Customer("Konopackis","Alex","","Mr");
        shop.storeCustomer(myCustomer);
        shop.writeCustomerData();
        Shop newShop = new Shop("Alex_shop");
        newShop.readCustomerData(); //read from "new_customer_data.txt"

        shop.printAllCustomers();
    }

    public void part3_step3()
    {
        //         /*
        //          * check on correct ID generator
        //          */
        //         System.out.print("\f"); //clean screen
        //         System.out.printf("Ganerate code 'GB-', 7\n"+shop.generateCustomerID("GB-",7)+"\n");
        //         System.out.printf("Ganerate code 'JK-', 1\n"+shop.generateCustomerID("JK-",1)+"\n");
        //         System.out.printf("Ganerate code 'PL-', 4\n"+shop.generateCustomerID("PL-",4)+"\n");
        //         System.out.printf("Ganerate code 'FH-', 0\n"+shop.generateCustomerID("FH-",0)+"\n");
        //         

        //         /*
        //          * check on generating ID if they equals "unknowm"
        //          */
        //         System.out.print("\f"); //clean screen
        //         Customer customer = new Customer("Konopackis", "Alex","","Mr");
        //         System.out.println("\fBefore storing in customerMap");
        //         customer.printDetails();
        // 
        //         shop.storeCustomer(customer);
        //         System.out.println("After storing in customerMap");
        //         shop.printAllCustomers(); 

        /*
         * check on generating UNIQUE id
         */
        shop.changeLengthOfId(1);
        for (int i=0; i<10; i++)
        {
            Customer customer = new Customer("Konopackis", "Alex","","Mr");
            shop.storeCustomer(customer);
        }
        shop.printAllCustomers(); 
    }

    public void part3_step4()
    {
        /*
         * check on storing two customer with same ID
         * (I create 2 custoemrs with ID==HL-45789 and trying to store them, the second ID will be changed automatically
         */
        System.out.print("\fStore 2 customers with same ID (HL-45789), then printing out all details\n"); //clean screen
        Customer customer = new Customer("Konopackis", "Alex","","Mr");
        customer.setCustomerID("HL-45789");
        shop.storeCustomer(customer);

        customer = new Customer("Smith", "Lee","R","Mr");
        customer.setCustomerID("HL-45789");
        shop.storeCustomer(customer);

        shop.printAllCustomers(); 
    }

    /*
     * Check correct work with Map (Store to the map and print details from the map)
     */
    public void part3_step5()
    {
        /*
         * test with customer object
         */
        System.out.print("\fTest on work with the map\n");
        Customer customer = new Customer("Konopackis", "Alex","","Mr");
        shop.storeCustomer(customer);
        shop.printAllCustomers(); 

        /*
         * test with shopItem object
         */
        //shop.readData();
        //shop.printItemDetails();
    }
}

