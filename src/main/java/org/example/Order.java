package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record Order(int id , Map<Product, Integer> products, OrderStatus orderStatus) {

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            total = total.add(product.price().multiply(BigDecimal.valueOf(quantity)));
        }

        return total;
    }
}
