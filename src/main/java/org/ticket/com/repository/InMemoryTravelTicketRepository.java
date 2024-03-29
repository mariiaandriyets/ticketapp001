package org.ticket.com.repository;

import org.springframework.stereotype.Component;
import org.ticket.com.model.Ticket;
import org.ticket.com.model.TravelTicket;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryTravelTicketRepository implements TravelTicketRepository{
  private Map<Long, TravelTicket> base = new HashMap<>();

    @PostConstruct
    private void init() {
        base.put(1L, new TravelTicket(1L, "Year", 1000.25));
        base.put(2L, new TravelTicket(2L, "Month", 180.00));
    }

    @Override
    public List<TravelTicket> findAll() {
        return new ArrayList<>(base.values());
    }

    @Override
    public TravelTicket findByPeriod(String period) {
        return null;
    }
}
