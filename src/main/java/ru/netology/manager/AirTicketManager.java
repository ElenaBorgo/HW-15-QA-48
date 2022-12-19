package ru.netology.manager;

import ru.netology.repo.AirTicketRepository;
import ru.netology.ticket.AirTicket;

import java.util.Arrays;

public class AirTicketManager {
    private AirTicketRepository repo;

    public AirTicketManager(AirTicketRepository repo) {
        this.repo = repo;
    }

    public void add(AirTicket ticket) {
        repo.add(ticket);
    }

    public AirTicket[] findAll(String from, String to) {
        AirTicket[] result = new AirTicket[0];
        for (AirTicket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                AirTicket[] tmp = new AirTicket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(AirTicket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}