package challenges.shopping.cart;

import java.util.Objects;

public class Item {

    private final String itemCode;
    private final String itemName;


    public Item(String itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return itemCode.equals(item.itemCode) &&
                itemName.equals(item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode, itemName);
    }

}
