package certification;

public enum  Season {

  WINTER{
    public void printHours(){
      System.out.println("...WINTER");
    }},
  SUMMER{
    public void printHours(){
      System.out.println("...SUMMER");
    }
  },
  SPRING{
    public void printHours(){
      System.out.println("...SPRING");
    }
  };

    public abstract void printHours();
}
