package com.test.shallow.deep;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

public class ShallowDeepComparison {

    public static void main(String args[]) {
        System.out.println("--");
        Employee e1 = new Employee(1, "name1");
        Employee e2 = new Employee(1, "name222");
        System.out.println("Shallow -> " + (e1 == e2));
        System.out.println("Deep -> " + e1.equals(e2));
    }

}

@Getter
@AllArgsConstructor
class Employee {

    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
