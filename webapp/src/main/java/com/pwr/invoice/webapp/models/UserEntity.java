package com.pwr.invoice.webapp.models;

import javax.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long Id; //swap to ID???
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToOne
    private CompanyEntity company;
    @Column
    private int accountType;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column
    private String password;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
