package org.example.bo.exemple3;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// int strategy joined every entity will be mapped to a table
// the only common attribute between the tables is the id
public class Persone {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String FirstName;
    private String LastName;
    @Column(unique = true)
    private String CIN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
}
