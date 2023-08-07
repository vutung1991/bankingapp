package com.example.newbankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    public static double interestRate = 0.25;
}
