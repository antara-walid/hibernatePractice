package org.example.bo.exemple1;


import javax.persistence.*;

@Entity(name = "ALIEN_TAB")
public class Alien {
    @GeneratedValue
    @Id
    Long aId;
    @Embedded
    AlienName aName;

    String color;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
