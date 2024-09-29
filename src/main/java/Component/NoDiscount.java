package Component;

import Entities.Product;

public class NoDiscount implements Discount {

    @Override
    public double apply(Product product) {
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        return "No eligible discount";
    }
}