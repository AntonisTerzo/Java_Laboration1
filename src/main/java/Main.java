import Component.Discount;
import Decorators.FridayDiscount;
import Decorators.MilkDiscount;
import Decorators.QuantityDiscount;
import Entities.Product;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("milk", 50, 5);
        Product cheese = new Product("cheese", 70, 5);
        Product cereal = new Product("cereal", 110, 2);

        Discount baseDiscount = new FridayDiscount(new MilkDiscount(new QuantityDiscount(null)));

        double milkDiscount = baseDiscount.apply(milk);
        double cheeseDiscount = baseDiscount.apply(cheese);
        double cerealDiscount = baseDiscount.apply(cereal);

        System.out.println("Welcome to the checkout.");
        System.out.println("You bought " + milk.quantity() + " bottles of " + milk.name());
        System.out.println("You bought " + cheese.quantity() + " slices of " + cheese.name());
        System.out.println("You bought " + cereal.quantity() + " boxes of " + cereal.name());
        System.out.println("------------");
        System.out.println("Your discounts are:");
        System.out.println("For milk: " + baseDiscount.getDescription(milk) + ": " + milkDiscount + "kr");
        System.out.println("For cheese: " + baseDiscount.getDescription(cheese) + ": " + cheeseDiscount + "kr");
        System.out.println("For cereal: " + baseDiscount.getDescription(cereal) + ": " + cerealDiscount + "kr");
    }
}
