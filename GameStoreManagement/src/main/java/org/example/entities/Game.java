package org.example.entities;

import java.sql.Date;
import java.util.Objects;

public class Game {
    //* ATTRIBUTES
    private Integer id;
    private String name;
    private Integer stock;
    private Boolean secondHand;
    //* CONSTRUCTORS
    public Game(String name, Integer stock, Boolean secondHand) {
        this.name = name;
        this.stock = stock;
        this.secondHand = secondHand;
    }
    public Game(Integer id, String name, Integer stock, Boolean secondHand) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.secondHand = secondHand;
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
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Boolean getSecondHand() {
        return secondHand;
    }
    public void setSecondHand(Boolean secondHand) {
        this.secondHand = secondHand;
    }
    //* HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(name, game.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    //* TO STRING
    @Override
    public String toString() {
        String seconhandText;
        if(secondHand){
            seconhandText = "SI";
        }else{
            seconhandText = "NO";
        }
        return """
                Game '%s': 
                    Nombre -> %s
                    Stock -> %s
                    Segunda mano -> %s
                ----------------------------------------------------------------------------
                """.formatted(id, name, stock ,seconhandText);
    }
}
