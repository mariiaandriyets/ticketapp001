package org.ticket.com.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.ticket.com.model.Ticket;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryTicketRepository implements TicketRepository{

    private Map<Long, Ticket> base = new HashMap<>();

    @PostConstruct
    private void init() {
        base.put(1L, new Ticket(1L, "Berlin", "Paris", 100.25));
        base.put(2L, new Ticket(2L, "Paris", "Hamburg", 150.30));
        base.put(3L, new Ticket(3L, "Bonn", "Hamburg", 90.10));
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(base.values());
    }

    @Override
    public Ticket findById(long id) {
        return base.get(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        Long currentIndex = base.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        ticket.setId(++currentIndex);
        base.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findByDestination(String destination) {
        return null;
    }
}
