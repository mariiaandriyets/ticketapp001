package org.ticket.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "travel_ticket")
public class TravelTicket extends TravelOption{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private long id;

    //@Pattern()
   // @NotEmpty
   // @Email
   // @NotNull
    @NotBlank(message = "Period cannot be empty")
    @Column(name = "period")
    private String period;

    @Max(value = 150, message = "Incorrect max value")
    @Min(value = 10, message = "Incorrect min value")
    private double price;

    public TravelTicket() {
        //
    }

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
