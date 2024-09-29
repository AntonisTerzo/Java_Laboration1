package Decorators;

import Entities.Product;

import Component.Discount;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract double calculateDiscount(Product product);

    protected abstract String getDiscountDescription(Product product);

    @Override
    public double apply(Product product) {
        double totalDiscount = 0.0;
        if (isApplicable(product)) {
            double discountAmount = calculateDiscount(product);
            totalDiscount += discountAmount;
        }
        if (nextDiscount != null) {
            totalDiscount += nextDiscount.apply(product);
        }
        return totalDiscount;
    }

    @Override
    public String getDescription(Product product) {
        StringBuilder description = new StringBuilder();

        if (isApplicable(product)) {
            description.append(getDiscountDescription(product));
        }

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product);
            if (!nextDescription.isEmpty()) {
                if (!nextDescription.equals("No eligible discounts")) {
                    if (description.length() > 0) {
                        description.append(" and ");
                    }
                    description.append(nextDescription);
                }
            }
        }
        return description.length() > 0 ? description.toString() : "No eligible discounts";
    }
}