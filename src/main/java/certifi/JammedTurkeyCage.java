package certifi;


public class JammedTurkeyCage implements  AutoCloseable {


    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("......Cage door does not Close ");
    }


//    public static void main(String[] args) {
//        try(JammedTurkeyCage jt = new JammedTurkeyCage()){
//            throw new IllegalStateException("......turkeys Ran off ");
//        }catch(IllegalStateException ils ){
//            System.out.println(" caught " + ils.getMessage());
//
//            for(Throwable t : ils.getSuppressed()){
//                System.out.println( t.getMessage());
//            }
//        }
//    }

//    public static void main(String[] args) {
//        try(JammedTurkeyCage jt = new JammedTurkeyCage()){
//            throw new RuntimeException("......RT ....turkeys Ran off ");
//        }catch(IllegalStateException ils ){
//            System.out.println(" caught " + ils.getMessage());
//
//            for(Throwable t : ils.getSuppressed()){
//                System.out.println( t.getMessage());
//            }
//        }
//    }


    public static void main(String[] args) {
        try(JammedTurkeyCage jt = new JammedTurkeyCage()) {
            throw new RuntimeException("......RT ....turkeys Ran off ");
//        }catch(IllegalStateException ils ){
//
//        }
        }finally{
            throw new RuntimeException( " and we could nt find them .... ");

        }
    }

}
