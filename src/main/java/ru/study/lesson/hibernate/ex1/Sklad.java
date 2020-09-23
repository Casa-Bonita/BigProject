package ru.study.lesson.hibernate.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sklad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int sklad_id;

    private String sklad_address;

    public Sklad() {
    }

    public Sklad(String sklad_address) {
        this.sklad_address = sklad_address;
    }

    public int getSklad_id() {
        return sklad_id;
    }

    public void setSklad_id(int sklad_id) {
        this.sklad_id = sklad_id;
    }

    public String getSklad_address() {
        return sklad_address;
    }

    public void setSklad_address(String sklad_address) {
        this.sklad_address = sklad_address;
    }

    @Override
    public String toString() {
        return "Sklad{" +
                "sklad_id=" + sklad_id +
                ", sklad_address='" + sklad_address + '\'' +
                '}';
    }


}
