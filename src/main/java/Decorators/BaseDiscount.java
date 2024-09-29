package Decorators;

import Entities.Product;

import Component.Discount;
import Component.NoDiscount;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;
    private NoDiscount noDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

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
        }else {
            description.append(noDiscount.getDescription(product));
        }

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product);
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
