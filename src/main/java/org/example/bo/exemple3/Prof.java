package org.example.bo.exemple3;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idProf")

public class Prof extends Persone{
    private String NUmProf ;

    public String getNUmProf() {
        return NUmProf;
    }

    public void setNUmProf(String NUmProf) {
        this.NUmProf = NUmProf;
    }
}
