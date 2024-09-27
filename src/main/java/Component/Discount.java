package Component;

import Entities.CustomerCart;
import Entities.Product;

public interface Discount {
    double apply(Product product, CustomerCart customerCart);
    String getDescription(Product product, CustomerCart customerCart);
}
