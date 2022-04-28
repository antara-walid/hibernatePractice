package org.example.bo;

import javax.persistence.Embeddable;


// with embeddable we avoid creating another tables for embedded objects
@Embeddable
public class AlienName {
    private String firstName;
    private String LastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "AlienName{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
