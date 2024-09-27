package Decorators;

import java.util.Calendar;
import java.util.TimeZone;

import Component.Discount;
import Entities.Product;

public class FridayDiscount extends BaseDiscount{
    public static final double FRIDAY_DISCOUNT_10PERCENT = 0.1;
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
        return "Friday discount: 10%";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }
}
