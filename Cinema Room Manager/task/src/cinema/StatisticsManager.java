package cinema;

public class StatisticsManager {
    private static int totalIncome = 0;
    private static double bookedSeatsPercentage;

    public int getTotalIncome() {
        return totalIncome;
    }

    public double getBookedSeatsPercentage() {
        return bookedSeatsPercentage;
    }

    public static int calculateProfit() {
        if ((SeatManager.getAllRows() * SeatManager.getAllSeats()) < 60) {
            totalIncome = (SeatManager.getAllRows() * SeatManager.getAllSeats()) * 10;
        } else {
            TicketManager.setLargeRoom(true);
            totalIncome = ((SeatManager.getAllRows() / 2) * SeatManager.getAllSeats() * 10) +
                    ((SeatManager.getAllRows() - (SeatManager.getAllRows() / 2))* SeatManager.getAllSeats() * 8);
        }
        return totalIncome;
    }

    public static String calculatePercentageOfBookedSeats(){
        bookedSeatsPercentage = ((double) TicketManager.getNumberOfPurchasedTickets() /
                (SeatManager.getAllRows() * SeatManager.getAllSeats())) * 100;
        String formatted = String.format("%.2f",bookedSeatsPercentage);
        return formatted;
    }

    public static void showStatistics() {
        System.out.println("Number of purchased tickets: " + TicketManager.getNumberOfPurchasedTickets());
        System.out.println("Percentage: " +  calculatePercentageOfBookedSeats() + "%");
        System.out.println("Current income: " + "$" + TicketManager.getCurrentIncome());
        calculateProfit();
        System.out.println("Total income: " + "$" + totalIncome + "\n");
    }
}
