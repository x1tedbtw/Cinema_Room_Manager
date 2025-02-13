package cinema;

import java.util.Scanner;

public class Cinema {

    public void menu() {
        Scanner scan = new Scanner(System.in);

        while (true) {  // Infinite loop
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int userAnswer = scan.nextInt();

            if (userAnswer == 0) {
                System.out.println("Exiting...");
                return;
            } else if (userAnswer == 1) {
                SeatManager.displaySeats();
            } else if (userAnswer == 2) {
                TicketManager.setTicketPrice();
                SeatManager.displaySeats();
            } else if (userAnswer == 3) {
                StatisticsManager.showStatistics();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
