package ru.netology.ticket;

public class AirTicket implements Comparable<AirTicket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int flightTime;

    public AirTicket(int id, int price, String from, String to, int flightTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getFlightTime() {
        return flightTime;
    }

    @Override
    public int compareTo(AirTicket o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
