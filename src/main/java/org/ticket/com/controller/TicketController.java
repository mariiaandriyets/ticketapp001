package org.ticket.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticket.com.TicketApp;
import org.ticket.com.model.Ticket;
import org.ticket.com.service.TicketService;

import java.util.List;
import java.util.logging.Logger;

//CRUD - Create, Read, Update, Delete
//RESTful
//http://localhost:8080/api/tickets/ - list all (GET)
//http://localhost:8080/api/tickets/2 - get element by id (GET)
//http://localhost:8080/api/tickets/ - get by element (POST)
//http://localhost:8080/api/tickets/search - get by destination (POST)


@RestController
@RequestMapping("/api/tickets")
@Slf4j
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    public List<Ticket> getAll() {
        List<Ticket> tickets= service.findAll();
        log.debug("List all tickets is {}", tickets);
        return tickets;
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable int id) {
        log.info("Call method getById with id {} for ticket controller", id);
        return service.findById(id);
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.save(ticket);
    }

    @GetMapping("/search")
    public List<Ticket> findByDestination(@RequestParam String destination) {
        return service.findByDestination(destination);
    }
}
