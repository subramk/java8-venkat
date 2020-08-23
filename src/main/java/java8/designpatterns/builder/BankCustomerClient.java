package java8.designpatterns.builder;

public class BankCustomerClient {

    public static void main(String[] args) {

        final BankCustomer bankCustomer = new BankCustomer.CustomerBuilder("10000", "HDFC222")
                .with(builder -> {
                    builder.bankPostalCode = 600085;
                    builder.currentBalance=322.33;
                    builder.accountType ="Savings";
                })
                .build();

        System.out.println("~~~~~~~~~~~~~~~~Bank Customer is " + bankCustomer);
    }
}
