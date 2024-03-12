package org.ticket.com.service;

import ch.qos.logback.core.model.processor.AllowAllModelFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticket.com.TicketApp;
import org.ticket.com.model.Ticket;
import org.ticket.com.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository repository;

    @Override
    public List<Ticket> findAll() {
        return repository.findAll();
    }

    @Override
    public Ticket findById(long id) {
        Ticket ticket = repository.findById(id);
        log.debug("Ticket with id {}", id, ticket);
        return ticket;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public List<Ticket> findByDestination(String destination) {
        if(destination == null || destination.isEmpty()) {
            log.debug("Ticket with destination cannot be found because destination is null");
            return new ArrayList<>();
        }
        log.debug("Try to find ticket with destination {}", destination);
        return repository.findByDestination(destination);
    }
}
