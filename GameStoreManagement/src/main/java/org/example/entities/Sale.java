package org.example.entities;

public class Sale {
    //* ATTRIBUTES
    private Integer id;
    private Double price;
    private Integer customer_id;
    private Integer game_id;
    //* CONSTRUCTORS
    public Sale(Double price, Integer customer_id, Integer game_id) {
        this.price = price;
        this.customer_id = customer_id;
        this.game_id = game_id;
    }
    public Sale(Integer id, Double price, Integer customer_id, Integer game_id) {
        this.id = id;
        this.price = price;
        this.customer_id = customer_id;
        this.game_id = game_id;
    }
    //* GETTER AND SETTER
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
    public Integer getGame_id() {
        return game_id;
    }
    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }
    //* TO STRING
    @Override
    public String toString() {
        return """
                Sale '%s':
                    Price -> %s
                    Customer ID -> %s
                    Game ID -> %s
                    ----------------------------------------------------------------------------
                """.formatted(id, price, customer_id, game_id);
    }
}
