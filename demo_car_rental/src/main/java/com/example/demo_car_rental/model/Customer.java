package com.example.demo_car_rental.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -5499172417961772372L;

    public Customer(){
        super();
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "username", length = 50)
    private String username;

    @Size(min = 5, max = 60)
    @Column(name = "password", length = 60)
    private String password;

    @Size(min = 2, max = 50)
    @Column(name = "fullName", length = 50)
    private String fullName;

    @Column(name = "rent_car")
    private int rentCars;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Rent> rents = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
