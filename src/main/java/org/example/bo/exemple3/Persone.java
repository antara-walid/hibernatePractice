package org.example.bo.exemple3;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
// we don t use intety because persone will not have a table in our database
// so in this case persone should not be associated to other classes
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
