package com.trung.tamjava.master.Demospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data // thay cho getter setter va constructor...
@NoArgsConstructor // constructor rỗng
@AllArgsConstructor // constructor truyen vao tat ca
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động nhập id // trong db column id phải AI
    private int id;
    private String name;
    private int age;
}
