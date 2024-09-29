package Decorators;

import java.util.Calendar;
import java.util.TimeZone;

import Component.Discount;
import Entities.Product;

public class FridayDiscount extends BaseDiscount{
    private final double FRIDAY_DISCOUNT_10PERCENT = 0.1;
    private final String FRIDAY_DESCRIPTION = "Friday discount (10%)";
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    public FridayDiscount(Discount discount) {
        super(discount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * FRIDAY_DISCOUNT_10PERCENT;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return FRIDAY_DESCRIPTION;
    }

    @Override
    public boolean isApplicable(Product product) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }
}
