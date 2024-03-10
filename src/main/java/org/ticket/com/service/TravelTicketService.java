package org.ticket.com.service;

import org.ticket.com.model.TravelTicket;

import java.util.List;

public interface TravelTicketService {

    List<TravelTicket> findAll();

    TravelTicket findByPeriod(String period);
}
