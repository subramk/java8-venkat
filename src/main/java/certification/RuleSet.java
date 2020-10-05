package certification;

public enum RuleSet {

  STD("standadrd"),
  ROM("rom"),
  ISO("iso");

  private String description;


  RuleSet(String desc){
    this.description = desc;
  }



}
