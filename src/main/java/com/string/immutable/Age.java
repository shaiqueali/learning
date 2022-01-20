package com.string.immutable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Age {

    private int day;
    private int month;
    private int year;

    @Override
    public String toString() {
        return "Age{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
