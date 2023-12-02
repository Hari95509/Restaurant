import java.util.*;

class MenuItem {
    private String itemName;
    private double itemPrice;

    public MenuItem(String name, double price) {
        itemName = name;
        itemPrice = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}

class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getItemPrice();
        }
        return total;
    }
}

class Restaurant {
    private Map<Integer, MenuItem> menu;
    private List<Order> orders;

    public Restaurant() {
        menu = new HashMap<>();
        orders = new ArrayList<>();
    }

    public void addToMenu(int itemID, String itemName, double itemPrice) {
        MenuItem newItem = new MenuItem(itemName, itemPrice);
        menu.put(itemID, newItem);
    }

    public void displayMenu() {
        for (Map.Entry<Integer, MenuItem> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getItemName() + " - $" + entry.getValue().getItemPrice());
        }
    }

    public void createOrder(List<Integer> itemIDs) {
        Order newOrder = new Order();
        for (int id : itemIDs) {
            MenuItem menuItem = menu.get(id);
            if (menuItem != null) {
                newOrder.addItem(menuItem);
            } else {
                System.out.println("Item with ID " + id + " not found in the menu.");
            }
        }
        orders.add(newOrder);
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println("Order:");
            for (MenuItem item : order.getItems()) {
                System.out.println(item.getItemName() + " - $" + item.getItemPrice());
            }
            System.out.println("Total: $" + order.getTotalPrice() + "\n");
        }
    }
}

public class RestaurantOrderManagement {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Adding items to the menu
        restaurant.addToMenu(1, "Burger", 9.99);
        restaurant.addToMenu(2, "Pizza", 12.99);
        restaurant.addToMenu(3, "Salad", 6.99);

        // Displaying the menu
        System.out.println("Menu:");
        restaurant.displayMenu();

        // Creating orders
        List<Integer> order1Items = Arrays.asList(1, 2);
        restaurant.createOrder(order1Items);

        List<Integer> order2Items = Arrays.asList(2, 3);
        restaurant.createOrder(order2Items);

        // Displaying orders
        System.out.println("\nOrders:");
        restaurant.displayOrders();
    }
}
