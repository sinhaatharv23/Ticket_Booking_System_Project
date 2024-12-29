import java.util.*;
class Ticket {
    private int ticketId;
    private String passengerName;
    private String flightNumber;

    // Constructor to initialize ticket details
    public Ticket(int ticketId, String passengerName, String flightNumber) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Passenger: " + passengerName + ", Flight: " + flightNumber;
    }
}

class TicketBookingSystem {
    private static final int MAX_TICKETS = 100; // Maximum number of tickets available
    private List<Ticket> tickets = new ArrayList<>();
    private int ticketCounter = 1;

    // Book a ticket for a passenger
    public void bookTicket(String passengerName, String flightNumber) {
        if (tickets.size() >= MAX_TICKETS) {
            System.out.println("Sorry, no tickets available!");
        } else {
            Ticket newTicket = new Ticket(ticketCounter++, passengerName, flightNumber);
            tickets.add(newTicket);
            System.out.println("Ticket booked successfully!");
            System.out.println(newTicket);
        }
    }

    // Cancel a ticket using the ticket ID
    public void cancelTicket(int ticketId) {
        boolean found = false;
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketId() == ticketId) {
                iterator.remove();
                System.out.println("Ticket with ID " + ticketId + " has been canceled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Ticket ID " + ticketId + " not found!");
        }
    }

    // Display all booked tickets
    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets have been booked yet.");
        } else {
            System.out.println("Booked Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    // Check available tickets
    public void checkAvailability() {
        System.out.println("Tickets available: " + (MAX_TICKETS - tickets.size()));
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTicket Booking System");
            System.out.println("1. Book a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Display all booked tickets");
            System.out.println("4. Check ticket availability");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter flight number: ");
                    String flight = scanner.nextLine();
                    system.bookTicket(name, flight);
                    break;

                case 2:
                    System.out.print("Enter ticket ID to cancel: ");
                    int ticketId = scanner.nextInt();
                    system.cancelTicket(ticketId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    system.checkAvailability();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
