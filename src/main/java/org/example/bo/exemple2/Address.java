package org.example.bo.exemple2;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aId;

    private String city;

    // here in OneToOne we can add many useful attributes such as cascade but to prevent creating another foreign key in address table we add mappedBy ...
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sAdress")
    private Student student;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(aId, address.aId) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, city);
    }
}
