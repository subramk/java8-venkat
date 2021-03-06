package challenges.shopping.cart;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Objects;

public class ShoppingItem {

    private final Item item;
    private final int quantity;
    private final BigDecimal price;
    private final DiscountEnum discountEnum;

    public ShoppingItem(Item item, int quantity, BigDecimal price, DiscountEnum discountEnum) {
        this.item = item;
        this.quantity = (quantity == 0)  ? 1 : quantity ;
        this.price = (price != null) ? price : BigDecimal.ZERO;
        this.discountEnum = discountEnum;
    }

    public BigDecimal getPriceOfItems() {
        return BigDecimal.valueOf(this.quantity).multiply(this.price);
    }


    public BigDecimal getDiscountedPrice(LocalDate shoppingDate) {

        if ( (this.getDiscountEnum() != null && this.getDiscountEnum().getDiscountType().equals(DiscountType.WEEKLY) &&
                checkForDiscountThisWeek(this.getDiscountEnum().getDiscountStartDate(), this.getDiscountEnum().getGetDiscountEndDate(), shoppingDate))
                 ||
                (this.getDiscountEnum() != null &&  this.getDiscountEnum().getDiscountType().equals(DiscountType.PRODCUT_DISCOUNT))) {
            return calculateDiscountedPrice(getPriceOfItems(), this.getDiscountEnum().getDiscountPercentage());
        }

        return getPriceOfItems();

    }

    private boolean checkForDiscountThisWeek(LocalDate discountStartDate, LocalDate discountEndDate, LocalDate checkDate) {
        return discountStartDate.compareTo(checkDate)  * checkDate.compareTo(discountEndDate) >= 0 ;
    }


    private BigDecimal calculateDiscountedPrice(BigDecimal price, BigDecimal discountPercentage) {
        BigDecimal discounted =  price.multiply(getDiscountEnum().getDiscountPercentage().divide(BigDecimal.valueOf(100)));
        return getPrice().subtract(discounted);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DiscountEnum getDiscountEnum() {
        return discountEnum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingItem)) return false;
        ShoppingItem that = (ShoppingItem) o;
        return quantity == that.quantity &&
                item.equals(that.item) &&
                price.equals(that.price) &&
                discountEnum == that.discountEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity, price, discountEnum);
    }

}
