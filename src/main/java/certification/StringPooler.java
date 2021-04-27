package certification;

public class StringPooler {

  public static void main(String[] args) {
    StringPooler ops = new StringPooler();
    ops.doWork();

  }

  private void doWork() {

    String s1 = "Canada";
    String s2 = new String(s1);
    String s3 = "Canada";

    System.out.println(" s1.equals(s2):: " + s1.equals(s2)); // true
    System.out.println("s1 == s2:: " + s1 == s2 ) ;  // false
    System.out.println("s1 == s3:: " + s1 == s3 ) ;  // false
    System.out.println(" s1.equals(s3):: " + s1.equals(s3)); // true
  }
}
