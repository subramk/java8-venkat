package com.java8.dto;

import java.util.Set;
import java.util.stream.Collectors;

public class RuleSet {

  private String name ;
  private String description ;
  private int id ;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public static String collectRuleSetNames(final RuleSet ruleSet){
    return ruleSet.getName();
  }


}
