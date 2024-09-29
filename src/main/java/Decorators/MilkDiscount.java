package Decorators;

import Component.Discount;
import Entities.Product;

public class MilkDiscount extends BaseDiscount{
    private static final double MILK_DISCOUNT = 0.05; 
    private static final String MILK_DESCRIPTION = "Milk discount (5%)";


    public MilkDiscount(Discount discount) {
        super(discount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * MILK_DISCOUNT;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return MILK_DESCRIPTION;
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.name().toLowerCase().contains("milk");
    }
    
}
