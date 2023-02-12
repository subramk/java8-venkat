package java8.designpatterns.replace.ifelseblocks;

import java.util.Date;

public class Cart {

    private Double value;
    private int itemsInCart;
    private String status;
    private Date lastUpdated;


    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

    public int getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(final int itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double calcCart(Cart cart){

        Double result = 1.5 ;

        if(cart.getValue().doubleValue() == 6.0){
            result = cart.getValue().doubleValue() * 1.5;
        }else if(cart.getValue().doubleValue() == 7.0){
            result = cart.getValue().doubleValue() * 2.5;
        }

        return result;
    }
}
