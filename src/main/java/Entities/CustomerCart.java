package Entities;

import java.util.List;

public record Customer(String name, int age, List<Product> products) {
}
