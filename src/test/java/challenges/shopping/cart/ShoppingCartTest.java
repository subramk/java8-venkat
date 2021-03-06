
package challenges.shopping.cart;;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }


//    @Test
//    @DisplayName("to retrieve the total items in the basket")
//    void shouldReturnCorrectTotalItemsInBasket() {
//        assertEquals(shoppingCart.getTotalItems(), 4);
//    }

    @Test
    @DisplayName(" Buy Apples Milk and Break should cost £3.00 woth 10% discount for Apples mo special offers")
    void shouldBuyApplesMilkBReakAndReturnCorrectCalulatedPriceNoSpecialOffers() {

        // Bred
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-2", "Bread")).withPrice(new BigDecimal(.80)).createShoppingItem());
        // Milk
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-3", "Milk")).withPrice(new BigDecimal(1.30)).createShoppingItem());

        // Apples
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-4", "Apples")).withPrice(new BigDecimal(1)).createShoppingItem());

        // Assert
        assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("3.10"));
    }

    @Test
    @DisplayName(" Buy Apples Milk and Break should cost £3.00 woth 10% discount for Apples")
    void shouldBuyApplesMilkBReakAndReturnCorrectCalulatedPrice() {

        // Bred
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-2", "Bread")).withPrice(new BigDecimal(".80")).createShoppingItem());
        // Milk
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-3", "Milk")).withPrice(new BigDecimal("1.30")).createShoppingItem());

        // Apples
        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-4", "Apples")).withPrice(new BigDecimal("1")).withDiscount(DiscountEnum.TEN_PERCENT_A_WEEK).createShoppingItem());

        // Assert
        assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("3.10"));
    }

    @Test
    @DisplayName("should calculate price for the shopping cart")
    void shouldCalculatePriceIntheCart() {
      // Soup
     shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-1", "Soup")).withPrice(new BigDecimal(.65)).createShoppingItem());
     // Bred
     shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-2", "Bread")).withQuantity(1).withPrice(new BigDecimal(.80)).createShoppingItem());
     // Milk
     shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-3", "Milk")).withQuantity(1).withPrice(new BigDecimal(1.30)).createShoppingItem());
     // Apples
     shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-4", "Apples")).withQuantity(1).withPrice(new BigDecimal(1)).withDiscount(DiscountEnum.TEN_PERCENT_A_WEEK).createShoppingItem());

     // Assert
     assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("3.75"));


   }
//
//   @Test
//   @DisplayName(" basket with 2 apples")
//   void shouldCalculatePriceMultipleQuantiesForApples() {
//        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-4", "Apples")).withQuantity(2).withPrice(new BigDecimal(1)).createShoppingItem());
//        assertEquals(shoppingCart.getTotalPrice(), new BigDecimal("2"));
//   }
//
   @Test
   @DisplayName("apple discount for 10% of this week")
    void shouldDiscountForApple10Percent() {

      //  assertEquals(new BigDecimal(1).multiply(new BigDecimal(10)).multiply(new BigDecimal("0.01")).setScale(2, RoundingMode.HALF_DOWN),new BigDecimal("0.10" ));

        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-4", "Apples")).withPrice(new BigDecimal(1)).withDiscount(DiscountEnum.TEN_PERCENT_A_WEEK).createShoppingItem());
        assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("1.00"));

   }

   @Test
   @DisplayName("Buy 2 tins of soup and get 50% discount on price of bread")
    void shouldGetDiscountFor2TinsOfSoup() {
         shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-1", "Soup")).withQuantity(2).withPrice(new BigDecimal(.65)).createShoppingItem());
         shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-2", "Bread")).withPrice(new BigDecimal(.80)).withDiscount(DiscountEnum.LOAFBREAD_HALF_PRICE_FOR_2_SOUP).createShoppingItem());
        assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("1.70"));
   }

   @Test
    @DisplayName("current week offfer")
    void currentOffter() {
       shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-1", "Apples")).
               withPrice(new BigDecimal(1)).withDiscount(DiscountEnum.TEN_PERCENT_A_WEEK).createShoppingItem());
       shoppingCart.setShoppingDate(LocalDate.of(2021,03,29));
       assertEquals(shoppingCart.calculateDiscountedPrice(), new BigDecimal("1.00"));

    }

//   @Test
//   @DisplayName(" Buy items without price")
//    void buyItemsWithouthPrice() {
//        shoppingCart.addItem(new ShoppingItemBuilder().withItem(new Item("item-1", "Soup")).createShoppingItem());
//        assertEquals(shoppingCart.getTotalPrice(), new BigDecimal("0.00"));
//
//   }

}
