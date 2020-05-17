package com.java8.comparator.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Admin on 27/07/2019.
 */
public class Squirell {

    public String name;
    public int weight ;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof Squirell)) return false;

        final Squirell squirell = (Squirell) o;

        return new EqualsBuilder()
                .append(getWeight(), squirell.getWeight())
                .append(getName(), squirell.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getWeight())
                .toHashCode();
    }
}
