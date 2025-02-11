package cinema;

public class TicketManager {
    private static boolean largeRoom;
    private static int numberOfPurchasedTickets;
    private static int currentIncome;

    public boolean isLargeRoom() {
        return largeRoom;
    }

    public static int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public static int getCurrentIncome() {
        return currentIncome;
    }

    public static void setLargeRoom(boolean largeRoom) {
        TicketManager.largeRoom = largeRoom;
    }

    public static boolean checkForLargeRoom() {
        if ((SeatManager.getAllRows() * SeatManager.getAllSeats()) < 60) {
            setLargeRoom(false);
        } else {
            setLargeRoom(true);
        }
        return largeRoom;
    }

    public static int calculateTicketPrice(int selectedRow) {
        checkForLargeRoom();
        if (largeRoom) {
            int halfRows = SeatManager.getAllRows() / 2;
            return (selectedRow <= halfRows) ? 10 : 8;
        }
        return 10;
    }

    public static int setTicketPrice() {
        SeatManager.askForSeatInput();
        int ticketPrice = calculateTicketPrice(SeatManager.getRow());
        System.out.println("\nTicket price: $" + ticketPrice + "\n");
        numberOfPurchasedTickets += 1;
        currentIncome += ticketPrice;

        return ticketPrice;
    }


}
