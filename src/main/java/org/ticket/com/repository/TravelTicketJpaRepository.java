package org.ticket.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticket.com.model.TravelTicket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelTicketJpaRepository extends JpaRepository<TravelTicket, Long> {

    // Select * from travel_ticket where period = :period order by price desc;
    List<TravelTicket> findAllByPeriodOrderByPrice(String period);

    Optional<TravelTicket> findById(long id);

}
