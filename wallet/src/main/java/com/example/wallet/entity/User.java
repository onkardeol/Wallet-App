package com.example.wallet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String userName;
    private String password;

    @OneToMany(targetEntity = Currency.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userCur", referencedColumnName = "id")
    private List<Currency> currency;

    public User(final String userName, final String password) {
        this.userName = userName;
        this.password = password;
    }
}