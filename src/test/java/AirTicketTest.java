import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.AirTicketManager;
import ru.netology.repo.AirTicketRepository;
import ru.netology.ticket.AirTicket;

public class AirTicketTest {
    AirTicketRepository repo = new AirTicketRepository();
    AirTicketManager manager = new AirTicketManager(repo);

    AirTicket ticket1 = new AirTicket(24, 20_000, "SVO", "KJA", 270);
    AirTicket ticket2 = new AirTicket(52, 7000, "SVO", "KZN", 90);
    AirTicket ticket3 = new AirTicket(68, 5000, "LED", "VKO", 60);
    AirTicket ticket4 = new AirTicket(900, 2000, "SVO", "KJA", 270);
    AirTicket ticket5 = new AirTicket(67, 50_000, "SVO", "KJA", 300);
    AirTicket ticket6 = new AirTicket(103, 10_000, "LED", "VKO", 60);
    AirTicket ticket7 = new AirTicket(90, 15_000, "LED", "KZN", 90);
    AirTicket ticket8 = new AirTicket(78, 5000, "SVO", "KJA", 270);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test
    public void shouldAddTicket() {
        AirTicket ticket9 = new AirTicket(90, 15_000, "KJA", "VKO", 280);

        repo.add(ticket9);

        AirTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        AirTicket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        AirTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        AirTicket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(90);

        AirTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket8};
        AirTicket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketByAirport() {

        AirTicket[] expected = {ticket4, ticket8, ticket1, ticket5};
        AirTicket[] actual = manager.findAll("SVO", "KJA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotTicket() {
        AirTicket[] expected = {};
        AirTicket[] actual = manager.findAll("KZN", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifFindSomeTickets() {
        AirTicket[] expected = {ticket3, ticket6};
        AirTicket[] actual = manager.findAll("LED", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifFindOneTicket() {
        AirTicket[] expected = {ticket7};
        AirTicket[] actual = manager.findAll("LED", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

}
