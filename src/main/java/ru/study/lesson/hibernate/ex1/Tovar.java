package ru.study.lesson.hibernate.ex1;

import javax.persistence.*;
//название класса и его полей должны соответствовать названию таблицы и столбцов в ней
@Entity
public class Tovar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tovar_id;

    private String tovar_name;
    private String delivery_address;

    //обязательно нужен конструктор по умолчанию
    public Tovar() {}

    public Tovar(int tovar_id, String tovar_name, String delivery_address) {
        this.tovar_id = tovar_id;
        this.tovar_name = tovar_name;
        this.delivery_address = delivery_address;
    }



    @Override
    public String toString() {
        return "Tovar{" +
                "tovar_id=" + tovar_id +
                ", tovar_name='" + tovar_name + '\'' +
                ", delivery_address='" + delivery_address + '\'' +
                '}';
    }
}
