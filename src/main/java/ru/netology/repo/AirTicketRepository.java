package ru.netology.repo;

import ru.netology.ticket.AirTicket;

public class AirTicketRepository {
    private AirTicket[] tickets = new AirTicket[0];

    public void add(AirTicket ticket) {
        AirTicket[] tmp = new AirTicket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        AirTicket[] tmp = new AirTicket[tickets.length - 1];
        int counter = 0;
        for (AirTicket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[counter] = ticket;
                counter++;
            }
        }
        tickets = tmp;
    }

    public AirTicket[] findAll() {
        return tickets;
    }
}
