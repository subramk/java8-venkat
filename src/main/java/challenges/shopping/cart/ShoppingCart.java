package challenges.shopping.cart;;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

   private List<ShoppingItem> items = new ArrayList<>();

    private static LocalDate shoppingDate = LocalDate.now();


    public int getTotalItems() {
        return items.size();
    }

    public void addItem(ShoppingItem shoppingItem) {
        items.add(shoppingItem);
    }

    public BigDecimal getTotalPrice() {
         double totalPrice =  items.stream().mapToDouble(ShoppingCart::applyAsDouble).sum();
         return new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_DOWN);
    }

    public  BigDecimal calculateDiscountedPrice() {
        double discountedPrice =  items.stream().mapToDouble(ShoppingCart::applyAsDouble).sum();
        return new BigDecimal(discountedPrice).setScale(2, RoundingMode.HALF_DOWN);
    }

    private static double applyAsDouble(ShoppingItem shoppingItem) {
        return shoppingItem.getDiscountedPrice(shoppingDate).doubleValue();
    }
    public void setShoppingDate(LocalDate shoppingDate) {
        this.shoppingDate = shoppingDate;
    }


}
