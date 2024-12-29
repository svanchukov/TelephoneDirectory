package ru.svanchukov.telephone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "email", unique = true)
    private String email;
}
