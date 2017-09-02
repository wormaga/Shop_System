
/**
 * Shop class can store 'Tool' objects, print details of all objects and read the data for ElectricTool, HandTool, Perishable and Workwear. Class store all object in 'itemList', can print info about them (printItemDetails()).
 * Also Shop class can read customer data with method readCustomerData(), data is stored in 'custoemrList', you can add created cutomer with storeCustomer() method.
 * You can view all customers calling method printAllCustomers() or you can write them in a file with method writeCustomerData().
 * 
 * @author (Aleksandrs Konopackis) 
 * @version (v2 28.03.2017)
 * 
 */
import java.io.*;
import java.awt.*;
import java.util.*;
import java.io.PrintWriter;
import java.util.HashMap;

public class Shop
{

    private HashMap<String, Customer> customerMap;
    private HashMap<String, ShopItem> itemMap;
    private Random randomGenerator;
    private int number=6; //lenght of Customer ID
    private HashMap<String, ShopItemReservation> itemReservationMap; //shopItemReservationMap 
    private Diary diary;
    private String dumpCustomerDataFileName;
    private String dumpItemReservationDataFileName;
    private String name;

    /**
     * Constructor for objects of class Shop. Difines Array list for storing ElectricTools and HandTools
     */
    public Shop(String name)
    {
        this.name = name;
        dumpCustomerDataFileName = "CustomerData_dump.txt";
        dumpItemReservationDataFileName = "ReservationData_dump.txt";
        customerMap = new HashMap<String, Customer>();
        itemMap = new HashMap<String, ShopItem>();
        itemReservationMap = new HashMap<String, ShopItemReservation>();
        randomGenerator = new Random();
        diary = new Diary();

        reloadSystem();
    }

    private void readCustomerDateFromPreviousSessions()
    {
        String absolute_path = dumpCustomerDataFileName;
        readCustomerData(absolute_path);
    }

    private void readShopItemDateFromPreviousSessions()
    {
        String absolute_path = "items_all.txt";
        readItemData(absolute_path);
    }

    private void readReservationDateFromPreviousSessions()
    {
        String absolute_path = dumpItemReservationDataFileName;
        readItemReservationData(absolute_path);
    }

    public void printDiaryEntries(String startDate, String endDate)
    {
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
    }

    public void storeItemReservation(ShopItemReservation item)
    {
        itemReservationMap.put(item.getReservationNo(), item);
        diary.addItemReservation(item);
    }

    public void deleteItemReservation (ShopItemReservation item)
    {
        itemReservationMap.remove(item.getReservationNo());
        diary.deleteItemReservation(item);

    }

    public String generateReservationNo() 
    {
        String answer = "";
        int num=-1;
        File file=null;
        Scanner sc=null;
        try
        {
            file =new File ("ReservationNumber.txt");
        }
        catch (NullPointerException e)
        {
            System.err.println("Cannot find 'ReservationNumber.txt' file");
        }

        try
        {
            sc =new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Cannot find 'ReservationNumber.txt' file");
        }

        num = sc.nextInt();
        sc.close();
        if (num < 1) num = 1;
        String lastGeneratedNumber = String.valueOf(num);
        for (int i=0; i<6-lastGeneratedNumber.length(); i++)
        {
            answer +="0";
        }

        try
        {
            PrintWriter out = new PrintWriter(file);
            out.println(++num);
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Cannot write to 'ReservationNumber.txt' file");
        }

        return answer + lastGeneratedNumber;
    }

    public ShopItemReservation getItemReservation(String reservationNo) 
    {
        return itemReservationMap.get(reservationNo);
    }

    /*
     * @TODO 
     * check that date is not in the past
     */
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays)
    {
        if (customerMap.containsKey(customerID))
        {
            if (DateUtil.isValidDateString(startDate))
            {
                if (noOfDays > 0 && noOfDays < 365)
                {
                    Collection<ShopItem> coll = itemMap.values();
                    for (ShopItem item : coll)
                    {
                        if (item.getItemCode().equals(itemID))
                        {
                            if (!itemIsBookedForThisTime( itemID,  startDate,  noOfDays))
                            {
                                String reservationNo = generateReservationNo();
                                ShopItemReservation item2 = new ShopItemReservation(reservationNo, itemID, customerID, startDate, noOfDays);
                                storeItemReservation(item2);
                                return true;
                            }
                            else
                            {
                                System.out.println("This item is already booked for these dates");
                                return false;
                            }
                        }

                    }
                    System.out.println("Item ID: "+itemID+" does not exist");
                    return false;
                }
                else 
                {
                    System.out.println("Nomber of days: "+noOfDays+" is wrong");
                    return false;
                }

            }
            else
            {
                System.out.println("The start date: "+startDate+" is not valid");
                return false;
            }
        }
        else
        {
            System.out.println("This customer ID: "+customerID+" does not exist");
            return false;
        }

    }

    private boolean itemIsBookedForThisTime(String itemID, String startDate, int noOfDays)
    {
        Date date = DateUtil.convertStringToDate(startDate);
        for (int i=0; i<noOfDays; i++)
        {
            ShopItemReservation[] shopItemReservations = diary.getItemReservations(date);
            int len=0;
            if (shopItemReservations!=null) len = shopItemReservations.length;

            for (int j=0; j<len; j++)
            {
                if (itemID.equals(shopItemReservations[j].getItemID()))
                {
                    return true;
                }
            }

            date = DateUtil.nextDate(date);
        }
        return false;
    }

    public void printItemReservations()
    {
        Collection<ShopItemReservation> coll = itemReservationMap.values();
        for (ShopItemReservation itemRes : coll)
        {
            itemRes.printDetails(); 
        }

        if (itemReservationMap.size()==0){
            System.out.println("Shop item reservation list is empty.");
        }
    }

    public String printReservationBetweenDates (String startDate, String endDate)
    {
        if (DateUtil.isValidDateString(startDate) && DateUtil.isValidDateString(endDate))
            {
                HashSet<ShopItemReservation> reservationSet = new HashSet<ShopItemReservation>();
                Date date = DateUtil.convertStringToDate(startDate);
                Date date_end = DateUtil.convertStringToDate(endDate);
                int noOfDays = DateUtil.daysBetween(date, date_end);
                if (noOfDays >= 0) //start Date is before end Date
                {
                    
                    for (int i=0; i<noOfDays; i++)
                    {
                        ShopItemReservation[] shopItemReservations = diary.getItemReservations(date);
                        int len=0;
                        if (shopItemReservations!=null) len = shopItemReservations.length;
                        for (int j=0; j<len; j++)
                        {
                            reservationSet.add(shopItemReservations[j]);
                        }
                        date = DateUtil.nextDate(date);
                    }

                    Iterator<ShopItemReservation> it = reservationSet.iterator();
                    while (it.hasNext())
                    {
                        it.next().printDetails();
                    }
                    if (reservationSet.size()==0){
                        System.out.println("There are no reservation between "+startDate+" and "+endDate);
                    }
                    return("");
                }
                else
                {
                    return("\nStartDate must be before EndDate");
                }

            }
            else
            {
                return("\nDate format is wrong, it should be dd-mm-yyyy");
            }
    }
    public void writeItemReservationData() 
    {
        if (itemReservationMap.isEmpty()) 
        {
            System.out.println("Reservation list is empty");
            return;
        }

        String filename = null;
        Frame frame = null;
        FileDialog fDialog = new FileDialog(frame, "save", FileDialog.SAVE);
        fDialog.setVisible(true);
        filename = fDialog.getFile();
        String fileDirectory = fDialog.getDirectory();
        writeItemReservationData(fileDirectory + filename);

    }

    private void writeItemReservationData(String filename)
    {
        PrintWriter pwriter = null;
        try
        {
            pwriter = new PrintWriter(filename);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("*** FileNotFoundExeption ***");
            System.err.println("Data file \""+filename+"\" does not exist");
            System.err.println("You may deleted it or did not selected file");
        }

        pwriter.println("// New reservation data");
        pwriter.println("// data is reservationNo, itemID,ring customerID, startDate, noOfDays");

        Collection<ShopItemReservation> coll = itemReservationMap.values();
        for (ShopItemReservation item: coll) 
            item.writeData(pwriter);

        pwriter.close();      
    }

    public void readItemReservationData()
    {
        Frame frame = null;
        FileDialog fDialog = new FileDialog(frame, "open", FileDialog.LOAD);
        fDialog.setVisible(true);
        String filename = fDialog.getFile();
        String fileDirectory = fDialog.getDirectory();

        readItemReservationData(fileDirectory + filename);

        System.out.println("You have successfully read the file:");
        System.out.println (fileDirectory+filename);    
    } 

    public void readItemReservationData(String filename)
    {
        Scanner sc = null;
        File file = new File(filename);
        try
        {
            sc = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("*** FileNotFoundExeption ***");
            System.err.println("Data file \""+filename+"\" does not exist");
            System.err.println("You may deleted it or did not selected file");
        }

        while (sc.hasNext())
        {
            String lineOfText = sc.nextLine();
            lineOfText=lineOfText.trim();

            if (!lineOfText.isEmpty()  &&   !lineOfText.startsWith("//"))
            {

                Scanner sc1 = new Scanner(lineOfText);
                sc1.useDelimiter(",");

                ShopItemReservation itemRes = new ShopItemReservation();
                itemRes.readData(sc1);

                if (itemRes!=null) 
                {

                    storeItemReservation(itemRes);
                    sc1.close();
                }

            }
        }
        sc.close();
    }

    //     public void addItem(ShopItem item)
    //     {
    //         itemList.add(item);
    //     }

    public void addItem(ShopItem item)
    {
        //if it is unique then????
        itemMap.put(item.getItemCode(), item);
    }

    public void printItemDetails()
    {

        //         if (!itemList.isEmpty())//itemList.forEach(item -> item.printDetails());
        //         {
        //             
        //             for (ShopItem item: itemList)
        //             }
        // 
        //         else 
        //             System.out.println("List is empty.\nRead the data and try it again");

        Collection<ShopItem> coll = itemMap.values();
        for (ShopItem item : coll)
        {
            item.printDetails(); 
        }

        if (itemMap.size()==0){
            System.out.println("Shop item list is empty.\nRead the data and try it again");
        }
    }

    public void readItemData()  
    {
        Frame frame = null;
        FileDialog fDialog = new FileDialog(frame, "open", FileDialog.LOAD);
        fDialog.setVisible(true);
        String filename = fDialog.getFile();
        String fileDirectory = fDialog.getDirectory();

        readItemData(fileDirectory + filename);

        System.out.println("You have successfully read the file:");
        System.out.println (fileDirectory+filename);

    }     

    public void readItemData(String filename)
    {
        String typeOfData= "";
        Scanner sc = null;
        File file = new File(filename);
        try
        {
            sc = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("*** FileNotFoundExeption ***");
            System.err.println("Data file \""+filename+"\" does not exist");
            System.err.println("You may deleted it or did not selected file");
        }

        while (sc.hasNext())
        {
            String lineOfText = sc.nextLine();
            lineOfText=lineOfText.trim();

            if (!lineOfText.isEmpty()  &&   !lineOfText.startsWith("//"))
            {
                if (lineOfText.startsWith("["))
                {
                    typeOfData = lineOfText.toLowerCase();
                }
                else
                {
                    Scanner sc1 = new Scanner(lineOfText);
                    sc1.useDelimiter(",");
                    ShopItem item = null;

                    switch (typeOfData)
                    {
                        case "[electrictool data]" : item = new ElectricTool(); break;
                        case "[handtool data]" : item = new HandTool(); break;
                        case "[perishable data]" : item = new Perishable(); break;
                        case "[workwear data]" : item = new Workwear(); break;
                        default : item = null; break;
                    }

                    if (item!=null) 
                    {
                        item.extractData(sc1);
                        addItem(item);
                        sc1.close();
                    }
                }
            }
        }
        sc.close();
    }
    //     public void storeCustomer(Customer customer)
    //     {
    //         customerList.add(customer);
    //     }
    public void storeCustomer(Customer customer)
    {
        //         if (programFisrtRun)
        //         {
        //             programFisrtRun=false;
        //             System.out.println("You are storing the first customer from program was run.\nDo you want to read saved customer data from previous session? (Y/N)");
        //             Scanner sc = new Scanner(System.in);
        //             String answer = sc.next();
        //             sc.close();
        //             if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
        //             {
        //                 System.out.println("Please choose the saved file from previous session to read customers' data");
        //                 readCustomerData();
        //             }
        //             
        //         }

        if (checkUnique(customer) && !customer.getCustomerID().equals("unknown"))
        {
            customerMap.put(customer.getCustomerID(), customer) ;
        }
        else
        {
            customer.setCustomerID(generateCustomerID("AB-", number));
            storeCustomer(customer);
        }

    }

    public void printAllCustomers()
    {
        //         if (!customerList.isEmpty())//customerList.forEach(customer -> customer.printDetails());
        // 
        //             for (Customer customer: customerList) 
        //                 customer.printDetails();
        // 
        //         else 
        //             System.out.println("Customer list is empty.\nRead the data and try it again");

        Collection<Customer> coll = customerMap.values();
        for (Customer customer : coll)
        {
            customer.printDetails(); 
        }

        if (customerMap.size()==0){
            System.out.println("Customer list is empty.\nRead the data and try it again");
        }
    }

    public void readCustomerData()
    {
        Frame frame = null;
        FileDialog fDialog = new FileDialog(frame, "open", FileDialog.LOAD);
        fDialog.setVisible(true);
        String filename = fDialog.getFile();
        String fileDirectory = fDialog.getDirectory();

        readCustomerData(fileDirectory + filename);

        System.out.println("You have successfully read the file:");
        System.out.println (fileDirectory+filename);    
    } 

    public void readCustomerData(String filename)
    {
        Scanner sc = null;
        File file = new File(filename);
        try
        {
            sc = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("*** FileNotFoundExeption ***");
            System.err.println("Data file \""+filename+"\" does not exist");
            System.err.println("You may deleted it or did not selected file");
        }

        while (sc.hasNext())
        {
            String lineOfText = sc.nextLine();
            lineOfText=lineOfText.trim();

            if (!lineOfText.isEmpty()  &&   !lineOfText.startsWith("//"))
            {

                Scanner sc1 = new Scanner(lineOfText);
                sc1.useDelimiter(",");

                Customer customer = new Customer();
                customer.readData(sc1);

                if (customer!=null) 
                {

                    storeCustomer(customer);
                    sc1.close();
                }

            }
        }
        sc.close();
    }

    /*
     * @TODO
     * write ShopItems data to file
     */
    public void writeItemData() 
    {

    }

    public void writeCustomerData()
    {

        if (customerMap.isEmpty()) 
        {
            System.out.println("Customer list is empty");
            return;
        }

        String filename = null;
        Frame frame = null;
        FileDialog fDialog = new FileDialog(frame, "save", FileDialog.SAVE);
        fDialog.setVisible(true);
        filename = fDialog.getFile();
        String fileDirectory = fDialog.getDirectory();
        writeCustomerData(fileDirectory + filename);
    }

    public void writeCustomerData(String filename)
    {
        PrintWriter pwriter = null;
        try
        {
            pwriter = new PrintWriter(filename);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("*** FileNotFoundExeption ***");
            System.err.println("Data file \""+filename+"\" does not exist");
            System.err.println("You may deleted it or did not selected file");
        }

        pwriter.println("// New customer data");
        pwriter.println("// data is customerID, surname, firstName, otherInitials, title");

        Collection<Customer> coll = customerMap.values();
        for (Customer customer: coll) 
            customer.writeData(pwriter);

        pwriter.close();      
    }

    public ShopItem getItem(String itemID)
    {
        return itemMap.get(itemID);
    }

    public Customer getCustomer(String customerID)
    {
        return customerMap.get(customerID);
    }

    private String generateCustomerID(String prefix, int digits)
    {
        if (digits>0)
        {

            for (int i=0;i<digits;i++ ) 
            {
                prefix += randomGenerator.nextInt(10);
            } 
            return prefix;
        }
        else
        {
            System.out.println("Number or digits can not be 0!");
            return "";
        }
    }

    public boolean checkUnique(Customer customer)
    {
        return !customerMap.containsKey(customer.getCustomerID());
    }

    public void changeLengthOfId(int number)
    {
        if (number>0)
            this.number = number;
        else System.out.println("The number of digits in ID can not be less than 1");
    }

    public int getNumberOfItems() 
    {
        return itemMap.size();
    }
    
    public int getNumberOfCustomers() 
    {
        return customerMap.size();
    }
    
    public int getNumberOfReservations()
    {
        return itemReservationMap.size();
    }
    
    public  HashMap<String, Customer> getCustomerMap()
    {
        return customerMap;
    }
    
    public HashMap<String, ShopItem> getItemMap()
    {
        return itemMap;
    }
    
    public HashMap<String, ShopItemReservation> getItemReservationMap()
    {
        return itemReservationMap;
    }
    
    public Diary getDiary()
    {
        return diary;
    }
    
    public void reloadSystem()
    {
        customerMap.clear();
        itemMap.clear();
        itemReservationMap.clear();
        diary = new Diary();

        readCustomerDateFromPreviousSessions();
        readShopItemDateFromPreviousSessions();
        readReservationDateFromPreviousSessions();
    }

    public void closeDownSystem()
    {
        if (customerMap.size()>0)
        {
            String absolute_path = dumpCustomerDataFileName;
            writeCustomerData(absolute_path);
        }

        if (itemReservationMap.size()>0)
        {
            String absolute_path = dumpItemReservationDataFileName;
            writeItemReservationData(absolute_path);
        }

        //System.exit(0);
    }
}

