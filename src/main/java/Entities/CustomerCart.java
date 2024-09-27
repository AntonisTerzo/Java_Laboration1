package Entities;

import java.util.List;

public record CustomerCart(String name, int age, List<Product> products) {
}
