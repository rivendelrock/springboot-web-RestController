package com.rocio.curso.springbootweb.models;

public class User {

    private String name;
    private String lastName;
    private String email;
    
    public User(String name, String lastName, String email) {
        this(name,lastName);
        this.email = email;
    }
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    public User() {

    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

}
