package com.stl.java8.examples;

import java.util.Set;
import java.util.stream.Collectors;

import com.java8.dto.RuleSet;

public class CollectorsJoining {

  public static final String comma = ",";

  public String splitAndCollectRulesets(final Set<RuleSet> ruleSet ){

    return ruleSet.stream().map( r -> r.getName()).collect(Collectors.joining(comma));





    // return null ;
  }

}
