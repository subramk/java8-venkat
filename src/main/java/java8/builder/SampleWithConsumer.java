package java8.builder;

import java.util.function.Consumer;

class Mailer2{

    Mailer2 from(String addr){
        print("from");
        return this;
    }
    Mailer2 to(String to){
        print("to");
        return this;
    }
    Mailer2 subject(String subject) {
        print("subject");
        return this ;
    }
    Mailer2 msg(String msg){
        print("msg");
        return this;
    }

  public  static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer() ;
        block.accept(mailer);
        System.out.println("Sending ....... ");
    }

    static void print(String msg) {
        System.out.println(msg);
    }

}


public class SampleWithConsumer
{
/**
    Using a standard builder pattern to create a Mailer object
 */
    public static void main(String[] args) {
    // call send method with a mailer ... send() takes A Consumer<Mailer> as a parameter .

    Mailer2.send( mailer2 ->
               mailer2
              .from("some@com.com")
              .to("\"to@com.com\"")
              .msg("\"some msg\"")
              .subject("\"subj here...\""));

    }
}