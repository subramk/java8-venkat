package com.java8;


public enum Gender {

    MALE("male"), FEMALE("female"), UNKNOWN("unknown") ;

    protected String desc ;

    Gender(String desc){
        this.desc = desc ;

    }


}
