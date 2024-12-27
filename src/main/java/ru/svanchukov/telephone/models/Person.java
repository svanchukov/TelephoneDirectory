package ru.svanchukov.telephone.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "email")
    private String email;
}
