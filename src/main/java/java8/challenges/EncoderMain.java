package java8.challenges;


public class EncoderMain {

    //e.g. obj.encode(“XYZAAAAABBBBCCCCCCCCDDDDEEEEEEEEEFFFFHHHHHHHHHHPP”)
    //will return “XYZAAAAABBBB{C;8}DDDD{E;9}FFFF{H;10}PP”

    public static void main(String[] args) {
        Encoder encoder = Encoder.getEncoder();
        String returnVal = encoder.encode("XYZAAAAABBBBCCCCCCCCDDDDEEEEEEEEEFFFFHHHHHHHHHHPP");
        System.out.println(returnVal);

        //Need to move into a unit test
       // assertTrue("PAAAAABBBB{C;8}DDDD{E;9}FFFF{H;10}XYZ".contains(returnVal));
    }
}
