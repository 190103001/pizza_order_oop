public class Order{
    int cost;
    int pizzzaSize;
    int numberOfToppings = 0;
    static int total = 0;
    final int costOfToppings = 200;
    static int numberOfOrder = 0;
    static boolean discount = false;
    String toppings = "Cheese";

    public Order() {
        numberOfOrder++;
    }

    public void addToppings(final String topping) {
        toppings += " + " + topping;
        numberOfToppings++;
        cost += costOfToppings;
        total += cost;
    }

    public int setSize(final int size) {
        pizzzaSize = size;
        cost = size * 50;
        total += cost;
        return cost;
    }

    public static void setDiscount(final String answer) {
        if (answer.equals("Y") || answer.equals("y")) { 
            discount = true;
        } else {
            discount = false;
        }
    }

    public static int getNumber() {
        return numberOfOrder;
    }

    public int getCost() {
        return cost;
    }

    public String print() {
        final String res = pizzzaSize + "cm pizza, " + toppings + ":" + cost;
        return res;
	}
}