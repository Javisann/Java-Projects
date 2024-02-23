package org.example.entities;

public class Customer {
    //* ATTRIBUTES
    private Integer id;
    private String name;
    private String address;
    //* CONSTRUCTOR
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    //* GETTER AND SETTER
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //* TO STRING
    @Override
    public String toString() {
        return """
                Customer '%s': 
                    Nombre -> %s
                    Address -> %s
                ----------------------------------------------------------------------------
                """.formatted(id, name, address);
    }
}
