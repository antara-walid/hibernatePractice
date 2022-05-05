package org.example.bo.exemple3;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Etudiant extends Persone{

    @Column(unique = true)
    private String cne;

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }
}
