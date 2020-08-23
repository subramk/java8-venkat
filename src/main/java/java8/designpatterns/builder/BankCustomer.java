package java8.designpatterns.builder;

import java.util.function.Consumer;

public class BankCustomer {


    private final String accountNumber;
    private final String accountType ;
    private final String ifscCode;
    private final Double currentBalance;
    private final Integer bankPostalCode;

    private BankCustomer(CustomerBuilder customerBuilder){
        this.accountNumber = customerBuilder.accountNumber;
        this.accountType = customerBuilder.accountType;
        this.ifscCode = customerBuilder.ifscCode;
        this.currentBalance = customerBuilder.currentBalance;
        this.bankPostalCode = customerBuilder.bankPostalCode;

    }


     static class  CustomerBuilder {
        private  String ifscCode;
        private  String accountNumber;
        public  String accountType ;
        public  Double currentBalance;
        public  Integer bankPostalCode;

        public CustomerBuilder(final String accountNumber , final String ifscCode){
            this.accountNumber = accountNumber;
            this.ifscCode = ifscCode ;
        }

        // all the 'Setting' of values happens via this.
        // This is the only method we provide for the entire class to build the BankCustomer using the Builder pattern
        // Normal builder patterns Will  have several method one each for every property .
        public CustomerBuilder with(final Consumer<CustomerBuilder> consumer){
            consumer.accept(this); // this refers to the CustomerBuilder
            return this;
        }

        public BankCustomer build(){
            return new BankCustomer(this); // this refers to the CustomerBuilder
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public Double getCurrentBalance() {
            return currentBalance;
        }

        public Integer getBankPostalCode() {
            return bankPostalCode;
        }






    }
}
