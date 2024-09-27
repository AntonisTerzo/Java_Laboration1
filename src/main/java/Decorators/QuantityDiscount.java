package Decorators;

import Component.Discount;
import Entities.Product;

public class QuantityDiscount extends BaseDiscount{
    private static final double QUANTITY_DISCOUNT = 10.0;
    private static final int MINIMUM_QUANTITY = 5;
    private static final String QUANTITY_DESCRIPTION = "Quantity discount(at least " + MINIMUM_QUANTITY + " products): " + QUANTITY_DISCOUNT + "kr per product";

    public QuantityDiscount(Discount discount) {
        super(discount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.quantity() * QUANTITY_DISCOUNT;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return QUANTITY_DESCRIPTION;
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= MINIMUM_QUANTITY;
    }
}
