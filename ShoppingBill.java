import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

 

           
class Product
{
private String customername;
private String store;
private String pname;
private int qty;
private double price;
private double totalPrice;
// constructor
Product(String customername, String store, String pname, int qty, double price, double totalPrice)
{
this.customername = customername;
this.store=store;
this.pname = pname;
this.qty = qty;
this.price = price;
this.totalPrice = totalPrice;
}

public String getCustomername()
{
return customername;
}
public String getStore()
{
return store;
}
public String getPname()
{
return pname;
}
public int getQty()
{
return qty;
}
public double getPrice()
{
return price;
}
public double getTotalPrice()
{
return totalPrice;
}

public static void displayFormat()
{


System.out.format("----------------------------------------------------------------------------------------------------------------------------------------------");
System.out.print("\nCustomer \t\tStore Name \t\t Name  \t\t\tQuantity  \t\t\tRate \t\t\tTotal\n");
System.out.format("----------------------------------------------------------------------------------------------------------------------------------------------\n");
}


public void display()
{
System.out.format(" %-10s \t\t%-9s \t\t%-10s  \t%5d  \t\t\t\t%6f \n" ,customername, store, pname, qty, price);
}
}
public class ShoppingBill
{

public static void main(String args[])
{
String customername = null;
String store = null;
String productName = null;
int quantity = 0;
double price = 0.0;
double totalPrice = 0.0;
double overAllPrice = 0.0;
double cgst, sgst, subtotal=0.0, delivery=0.0;
char choice = '\0';
Random rand = new Random();
int rand_int1 = rand.nextInt(100000000);
int rand_int2 = rand.nextInt(1000);

System.out.println("\n\n\n\n");
System.out.println("\t\t\t\t                                    -----------------");
System.out.println("\t\t\t\t                                   | Delivery Service|");
System.out.println("\t\t\t\t                                   | (951) 934-2531  |");
System.out.println("\t\t\t\t                                    -----------------");
System.out.println("\n\t\t\t\t\t              -------------------Reciept-----------------\n\n\n\n");
System.out.println("Transaction #: " + rand_int1 + "\n");




SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
Date date = new Date();
Calendar calendar = Calendar.getInstance();
String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

System.out.println("Date: "+formatter.format(date)+" "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t\n");
Scanner scan = new Scanner(System.in);
System.out.print("Enter Customer Name: ");
String customer = scan.nextLine();

List<Product> product = new ArrayList<Product>();
do
{



System.out.println("Enter the product details");
System.out.println("------------------------- ");

System.out.print("Store: ");
store = scan.nextLine();
System.out.print("Product Name: ");
productName = scan.nextLine();
System.out.print("Quantity: ");
quantity = scan.nextInt();
System.out.print("Price (per unit): ");
price = scan.nextDouble();

totalPrice = price * quantity;

overAllPrice = overAllPrice + totalPrice;

product.add( new Product(customer, store, productName, quantity, price, totalPrice) );

System.out.print("Want to add more items? (y or n): ");

choice = scan.next().charAt(0);

scan.nextLine();
}
while (choice == 'y' || choice == 'Y');

Product.displayFormat();
for (Product p : product)
{
p.display();
}v


//price calculation
subtotal = overAllPrice+delivery;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Subtotal "+subtotal);
delivery = overAllPrice*10/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Delivery " +delivery);
sgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t SGST (%) "+sgst);
cgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t CGST (%) "+cgst);

System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Invoice Total " +(subtotal+cgst+sgst));
System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
System.out.println("\t\t\t\t                  ");
System.out.println("\t\t\t\t                   Visit Again");

scan.close();
}
}
