package challenges.shopping.cart;

import java.math.BigDecimal;

public class ShoppingItemBuilder {
    private Item item;
    private int quantity;
    private BigDecimal price;
    private DiscountEnum discount;

    public ShoppingItemBuilder withItem(Item item) {
        this.item = item;
        return this;
    }

    public ShoppingItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ShoppingItemBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ShoppingItemBuilder withDiscount(DiscountEnum discount) {
        this.discount = discount;
        return this;
    }

    public ShoppingItem createShoppingItem() {
        return new ShoppingItem(item, quantity, price, discount);
    }
}
