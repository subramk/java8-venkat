package java8.builder;

class Mailer{
    public static void print(String msg) {
        System.out.println(msg);

    }
    public Mailer from(String addr){
        print("from");
        return this;
    }
    public Mailer to(String addr){
        print("to");
        return this;
    }
    public Mailer subject(String addr) {
        print("body");
        return this ;
    }
    public Mailer msg(String addr){
        print("message");
        return this;
    }
    public Mailer send() {
        System.out.println(" sending msg ..... ");
        return this;
    }
}


public class Sample {
/**
    Using a standard builder pattern to create a Mailer object
 */
    public static void main(String[] args) {

        Mailer mailer = new Mailer() ;
        // builder pattern to build Mailer object and send .
        mailer.from("some@com.com").to("\"to@com.com\"").msg("\"some subject\"").subject("\"subj here...\"").send();



    }
}