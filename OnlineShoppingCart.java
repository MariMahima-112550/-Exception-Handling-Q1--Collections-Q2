/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlineshoppingcart;
import java.util.*;

public class OnlineShoppingCart {

    static Map<Integer, String> products = new HashMap<>();
    static Map<Integer, Double> prices = new HashMap<>();
    static List<Integer> cart = new ArrayList<>();
    static Set<Integer> categories = new HashSet<>();
    static Queue<Integer> orders = new LinkedList<>();

    public static void main(String[] args) {

        // Adding products using Map
        products.put(101, "Laptop");
        products.put(102, "Headphones");
        products.put(103, "Keyboard");
        products.put(104, "Mouse");

        prices.put(101, 55000.0);
        prices.put(102, 1500.0);
        prices.put(103, 1200.0);
        prices.put(104, 700.0);

        // Adding category IDs using Set
        categories.add(1);
        categories.add(2);
        categories.add(3);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Process Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Products ---");

                    for (int id : products.keySet()) {
                        System.out.println(id + " - "
                                + products.get(id)
                                + " - Rs." + prices.get(id));
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    if (products.containsKey(id)) {
                        cart.add(id);
                        System.out.println(
                                "Product added to cart.");
                    } else {
                        System.out.println(
                                "Invalid product ID.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Shopping Cart ---");

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        double total = 0;

                        for (int productId : cart) {
                            System.out.println(
                                    products.get(productId)
                                    + " - Rs."
                                    + prices.get(productId));

                            total += prices.get(productId);
                        }

                        System.out.println(
                                "Total Amount: Rs." + total);
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println(
                                "Cart is empty. Add products first.");
                    } else {
                        orders.add(cart.hashCode());
                        cart.clear();

                        System.out.println(
                                "Order placed successfully!");
                    }
                    break;

                case 5:
                    if (orders.isEmpty()) {
                        System.out.println(
                                "No orders to process.");
                    } else {
                        orders.poll();

                        System.out.println(
                                "Order processed successfully!");
                    }
                    break;

                case 6:
                    System.out.println(
                            "Thank you for shopping!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}