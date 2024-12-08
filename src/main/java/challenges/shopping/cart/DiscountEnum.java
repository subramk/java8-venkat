package challenges.shopping.cart;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum DiscountEnum {

    TEN_PERCENT_A_WEEK(DiscountType.WEEKLY, new BigDecimal("10"), LocalDate.of(2021, 02, 22), LocalDate.of(2021, 02, 28), null, 0),
    LOAFBREAD_HALF_PRICE_FOR_2_SOUP(DiscountType.PRODCUT_DISCOUNT, new BigDecimal("50"), null,null, "SOUP",2);


    final private DiscountType discountType;
    final private BigDecimal discountPercentage;
    final private LocalDate discountStartDate;



    final private LocalDate getDiscountEndDate;
    final private String discountedProduct;
    final private int discountedProductQuantity;

    DiscountEnum(DiscountType discountType, BigDecimal discountPercentage, LocalDate discountStartDate, LocalDate getDiscountEndDate, String discountedProduct, int discountedProductQuantity) {
        this.discountType = discountType;
        this.discountPercentage = discountPercentage;
        this.discountStartDate = discountStartDate;
        this.getDiscountEndDate = getDiscountEndDate;
        this.discountedProduct = discountedProduct;
        this.discountedProductQuantity = discountedProductQuantity;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getDiscountStartDate() {
        return discountStartDate;
    }

    public LocalDate getGetDiscountEndDate() {
        return getDiscountEndDate;
    }


}
