import java.util.ArrayList;
import java.util.Scanner;
public class PizzaOrderer{

    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        final ArrayList<Order> orders = new ArrayList<Order>();
        Others.Greet();
        Order.setDiscount(scan.nextLine());
        while (true) {
            final Order havchik = new Order();
            orders.add(havchik);
            Others.Pizzas();
            try {
                orders.get(Order.getNumber() - 1).setSize(scan.nextInt());
            } catch (final Exception e) {
                System.out.println("Enter a Digit!");
                orders.get(Order.getNumber() - 1).setSize(scan.nextInt());
            }
            Others.main(orders.get(Order.getNumber() - 1)); 
            Others.previewOrder(orders);
            Others.printMenu();
            switch (scan.nextInt()) {
            case 1:
                Others.confirmOrder(orders);
                System.exit(0);
            case 2:
                break;
            case 3:
                System.out.println("Good bye!");
                System.exit(0);
            default:
                System.exit(0);
            }
        }
    }

}