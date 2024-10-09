import java.util.Scanner;

// Enum for product categories
enum Category {
    ELECTRONICS,
    CLOTHING,
    GROCERIES
}

// Interface for applying discounts
interface Discountable {
    double applyDiscount();
}

// Base class Product
abstract class Product implements Discountable {
    String name;
    double price;
    Category category;

    // Constructor
    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Display product details
    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Category: " + category);
        System.out.println(String.format("Original Price: ₹%.2f", price));
        System.out.println(String.format("Discounted Price: ₹%.2f", applyDiscount()));
    }
}

// Electronics product class
class Electronics extends Product {
    // Constructor
    public Electronics(String name, double price) {
        super(name, price, Category.ELECTRONICS);
    }

    // Apply a 10% discount for electronics
    @Override
    public double applyDiscount() {
        return price - (price * 0.10); // 10% discount
    }
}

// Clothing product class
class Clothing extends Product {
    // Constructor
    public Clothing(String name, double price) {
        super(name, price, Category.CLOTHING);
    }

    // Apply a 20% discount for clothing
    @Override
    public double applyDiscount() {
        return price - (price * 0.20); // 20% discount
    }
}

// Groceries product class
class Groceries extends Product {
    // Constructor
    public Groceries(String name, double price) {
        super(name, price, Category.GROCERIES);
    }

    // Apply a 5% discount for groceries
    @Override
    public double applyDiscount() {
        return price - (price * 0.05); // 5% discount
    }
}

// Main class for input and display
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input category
        
        String categoryInput = scanner.nextLine().trim().toUpperCase();
        Category category = Category.valueOf(categoryInput);

        // Input product name
        
        String productName = scanner.nextLine().trim();

        // Input original price
        
        double originalPrice = scanner.nextDouble();

        // Create product object based on category
        Product product = null;
        switch (category) {
            case ELECTRONICS:
                product = new Electronics(productName, originalPrice);
                break;
            case CLOTHING:
                product = new Clothing(productName, originalPrice);
                break;
            case GROCERIES:
                product = new Groceries(productName, originalPrice);
                break;
            default:
                System.out.println("Invalid category");
                System.exit(0);
        }

        // Display product details and discounted price
        product.displayDetails();

        scanner.close();
    }
}
