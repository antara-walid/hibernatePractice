package org.example.bo.exemple2;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;
    @Column(unique = true)
    private String CIN;

    private String firstName;
    private String LastName;

    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true )
    private List<Address> sAdress = new ArrayList<>();

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

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

    public List<Address> getsAdress() {
        return sAdress;
    }

    public void setsAdress(List<Address> sAdress) {
        this.sAdress = sAdress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", CIN='" + CIN + '\'' +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sId, student.sId) && Objects.equals(CIN, student.CIN) && Objects.equals(firstName, student.firstName) && Objects.equals(LastName, student.LastName) && Objects.equals(sAdress, student.sAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, CIN, firstName, LastName, sAdress);
    }
}
