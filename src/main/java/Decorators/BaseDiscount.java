package Decorators;

import Entities.CustomerCart;
import Entities.Product;

import Component.Discount;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    protected abstract String getDiscountDescription(Product product);

    @Override
    public double apply(Product product, CustomerCart customerCart) {
        double totalDiscount = 0.0;
        if (isApplicable(product)) {
            double discountAmount = calculateDiscount(product);
            totalDiscount += discountAmount;
        }
        if (nextDiscount != null) {
            totalDiscount += nextDiscount.apply(product, customerCart);
        }
        return totalDiscount;
    }

    @Override
    public String getDescription(Product product, CustomerCart customerCart) {
        StringBuilder description = new StringBuilder();

        if (isApplicable(product)) {
            description.append(getDiscountDescription(product));
        }

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product, customerCart);
            if (!nextDescription.isEmpty()) {
                if (description.length() > 0) {
                    description.append(", ");
                }
                description.append(nextDescription);
            }
        }

        return description.toString();
    }
}
