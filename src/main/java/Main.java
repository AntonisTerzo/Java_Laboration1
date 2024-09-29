import Component.Discount;
import Component.NoDiscount;
import Decorators.FridayDiscount;
import Decorators.MilkDiscount;
import Decorators.QuantityDiscount;
import Entities.Product;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("milk", 50, 3);
        Product cheese = new Product("cheese", 70, 5);
        Product cereal = new Product("cereal", 110, 2);

        Discount noDiscount = new NoDiscount();
        Discount baseDiscount = new FridayDiscount(new MilkDiscount(new QuantityDiscount(noDiscount)));

        double milkDiscount = baseDiscount.apply(milk);
        double cheeseDiscount = baseDiscount.apply(cheese);
        double cerealDiscount = baseDiscount.apply(cereal);

        
        System.out.println(baseDiscount.getDescription(milk) + " " + milkDiscount + "kr");
        System.out.println(baseDiscount.getDescription(cheese) + " " + cheeseDiscount + "kr");
        System.out.println(baseDiscount.getDescription(cereal) + " " + cerealDiscount + "kr");
    }
}
