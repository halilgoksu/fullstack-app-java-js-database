package com.revature.Ticket.entity;

public class Ticket {
    private int id;
    private String name;
    private String amount;

    private String description;



    public Ticket() {

    }


    public Ticket(int id, String name, String amount,String description) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.description=description;
    }

    public Ticket(String name, String amount,String description) {
        this.name = name;
        this.amount = amount;
        this.description=description;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + amount + '\'' +
                ", password='" + description + '\'' +

                '}';
    }
    


}
