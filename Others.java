import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Others {
    public static void Greet() {
        System.out.println("====================================");
        System.out.println("Welcome to \"Eat&Chat\" Pizza Order!");
        System.out.println("====================================");
        System.out.printf("Today is: %s", printCurrentDate());
        System.out.print("\n> Is it your BIRTHDAY? (10% discount available on presenting ID)  (Y/N):  ");
    }

    public static void printMenu() {
        System.out.println("------------MENU-------------");
        System.out.println("1 - Complete");
        System.out.println("2 - Add another order");
        System.out.println("3 - Exit");
        System.out.print("> Choose one of the above (Enter a number): ");
    }

    public static void Pizzas() {
        System.out.println("-----------------------------");
        System.out.println("Pizza Size (cm)      Cost");
        System.out.println("       20            1000 T");
        System.out.println("       30            1500 T");
        System.out.println("       40            2000 T");
        System.out.println("What size pizza would you like?");
        System.out.print("> 20, 30, or 40 (enter the number only): ");
    }

    public static void main(final Order orders) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are 200T each," + " choose from:");
        System.out.println("- Meat, Sausage, Vegetables, Mushroom");
        System.out.print("> Do you want Meat?  (Y/N):  ");
        if (scan.nextLine().equalsIgnoreCase("y"))
            orders.addToppings("Meat");
        System.out.print("> Do you want Sausage?  (Y/N):  ");
        if (scan.nextLine().equalsIgnoreCase("y"))
            orders.addToppings("Sausage");
        System.out.print("> Do you want Vegetables?  (Y/N):  ");
        if (scan.nextLine().equalsIgnoreCase("y"))
            orders.addToppings("Vegetables");
        System.out.print("> Do you want Mushroom?  (Y/N):  ");
        if (scan.nextLine().equalsIgnoreCase("y"))
            orders.addToppings("Mushroom");
    }

    public static void confirmOrder(final ArrayList<Order> orders) {
        System.out.println("#############################################");
        previewOrder(orders);
        int cost = getTotalCost(orders);
        if (Order.discount) {
            cost = (cost * 9) / 10;
            System.out.println("-----------------------------");
            System.out.println("TOTAL with DISCOUNT (on presening ID only!):\n" + cost + " T");
        }
        System.out.println("-----------------------------");
        System.out.println("Your order will be ready for pickup in 30 minutes.");
        System.out.printf("Date: %s\tTime: %s\nOrder ID: %s \n", printCurrentDate(), printCurrentTime(), generateCode());
    }

    public static void previewOrder(final ArrayList<Order> orders) {
        System.out.println("-----------------------------");
        System.out.println("Your order: ");
        for (int num = 0; num < orders.size(); num++) {
            System.out.println(num + 1 + ") " + orders.get(num).print());
        }
        System.out.println("Total: " + getTotalCost(orders) + " T");
    }

    private static int getTotalCost(final ArrayList<Order> orders) {
        int total = 0;
        for (int x = 0; x < orders.size(); x++) {
            total += orders.get(x).cost;
        }
        return total;
    }

    public static String printCurrentDate(){
		final Date curdate=new Date();
		final SimpleDateFormat formatdate=new SimpleDateFormat("dd.MM.yyyy");
        return formatdate.format(curdate);
	}
	public static String printCurrentTime(){
		final Date curtime=new Date();
		final SimpleDateFormat formattime=new SimpleDateFormat("HH:mm");
		return formattime.format(curtime);
	}
	public static String generateCode(){
        int randCode = (int) (Math.random() * 9999);
		return String.format("%04d", randCode);
	}
}