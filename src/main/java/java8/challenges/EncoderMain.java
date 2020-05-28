package java8.challenges;


public class EncoderMain implements Encoder {


    //e.g. obj.encode(“XYZAAAAABBBBCCCCCCCCDDDDEEEEEEEEEFFFFHHHHHHHHHHPP”)
    //will return “XYZAAAAABBBB{C;8}DDDD{E;9}FFFF{H;10}PP”

    public static Encoder of() {
        return new EncoderMain();
    }

    public static void main(String[] args) {
        //  Encoder encoderMain = new EncoderMain();
        String returnVal = of().encode("XYZAAAAABBBBCCCCCCCCDDDDEEEEEEEEEFFFFHHHHHHHHHHPP");
        System.out.println(returnVal);

        //Need to move into a unit test
        // assertTrue("PAAAAABBBB{C;8}DDDD{E;9}FFFF{H;10}XYZ".contains(returnVal));
    }

    @Override
    public String encode(String encode) {
        return getEncoder().encode(encode);
    }
}

