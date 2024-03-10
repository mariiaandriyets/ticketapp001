package org.ticket.com.model;

public class TravelTicket extends TravelOption{

    private long id;

    private String period;

    private double price;

    public TravelTicket(long id, String period, double price) {
        this.id = id;
        this.period = period;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
