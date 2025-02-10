package cinema;

import java.util.Scanner;

import static java.lang.System.in;

public class Cinema {
    private boolean largeRoom;
    private int allRows;
    private int allSeats;
    private int row;
    private int seat;
    private char[][] seats;
    private int numberOfPurchasedTickets;
    private int currentIncome;
    private int totalIncome = 0;
    private double bookedSeatsPercentage;


    public int getAllRows() {
        return allRows;
    }

    public boolean isLargeRoom() {
        return largeRoom;
    }

    public void setLargeRoom(boolean largeRoom) {
        this.largeRoom = largeRoom;
    }

    public void askForSeatArrangement() {
        Scanner scan = new Scanner(in);
        System.out.println("Enter the number of rows:");
        allRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        allSeats = scan.nextInt();

        seats = new char[allRows][allSeats];
        for (int i = 0; i < allRows; i++) {
            for (int j = 0; j < allSeats; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    public int calculateProfit() {
        if ((allRows * allSeats) < 60) {
            totalIncome = (allRows * allSeats) * 10;
        } else {
            setLargeRoom(true);
            totalIncome = ((allRows / 2) * allSeats * 10) + ((allRows - (allRows / 2))* allSeats * 8);
        }
        return totalIncome;
    }

    public int setTicketPrice() {
        askForSeatInput();
        int ticketPrice = calculateTicketPrice(row);
        System.out.println("\nTicket price: $" + ticketPrice + "\n");
        numberOfPurchasedTickets += 1;
        currentIncome += ticketPrice;

        return ticketPrice;
    }


    public boolean checkForLargeRoom() {
        if ((allRows * allSeats) < 60) {
            setLargeRoom(false);
        } else {
            setLargeRoom(true);
        }
        return largeRoom;
    }

    public void askForSeatInput() {
        Scanner scan = new Scanner(in);

        while (true) {  // Infinite loop
            System.out.println("Enter a row number: ");
            row = scan.nextInt();
            System.out.println("Enter a seat number in that row: ");
            seat = scan.nextInt();

            if (row < 1 || row > allRows || seat < 1 || seat > allSeats) {
                System.out.println("Wrong input!");
                continue;
            }


            if (seats[row - 1][seat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;  // Restart loop
            }

            seats[row - 1][seat - 1] = 'B';
            break;  // Exit the loop
        }
    }

    public int calculateTicketPrice(int selectedRow) {
        checkForLargeRoom();
        if (largeRoom) {
            int halfRows = allRows / 2;
            return (selectedRow <= halfRows) ? 10 : 8;
        }
        return 10;
    }

    public void displaySeats() {
        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 1; i <= allSeats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < allRows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < allSeats; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public String calculatePercentageOfBookedSeats(){
        bookedSeatsPercentage = ((double) numberOfPurchasedTickets / (allRows * allSeats)) * 100;
        String formatted = String.format("%.2f",bookedSeatsPercentage);
        return formatted;
    }

    public void showStatistics() {
        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.println("Percentage: " +  calculatePercentageOfBookedSeats() + "%");
        System.out.println("Current income: " + "$" + currentIncome);
        calculateProfit();
        System.out.println("Total income: " + "$" + totalIncome + "\n");
    }

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
                displaySeats();
            } else if (userAnswer == 2) {
                setTicketPrice();
                displaySeats();
            } else if (userAnswer == 3) {
                showStatistics();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }



    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.askForSeatArrangement();
        cinema.menu();
        cinema.showStatistics();


//        cinema.printSeats();
//        cinema.calculateProfit();
//        cinema.setTicketPrice();
//        cinema.printReservedSeats();
    }
}
