package challenges.interest.rate.calculator;


public class Customer {

    private String customerID;
    private BandType bandType;

    public Customer(String customerID, BandType bandType) {
        this.customerID = customerID;
        this.bandType = bandType;
    }

    public BandType getBandType() {
        return bandType;
    }
}
