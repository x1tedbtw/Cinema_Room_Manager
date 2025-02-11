package cinema;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        SeatManager seatManager = new SeatManager();
        StatisticsManager statisticsManager = new StatisticsManager();
        TicketManager ticketManager = new TicketManager();


        seatManager.askForSeatArrangement();
        cinema.menu();
    }

}
