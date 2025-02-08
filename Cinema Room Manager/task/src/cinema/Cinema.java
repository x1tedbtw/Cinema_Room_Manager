package cinema;

import java.util.Scanner;

import static java.lang.System.in;

public class Cinema {
    private boolean largeRoom;
    private int allRows;
    private int allSeats;
    private int row;
    private int seat;

    public int getAllRows() {
        return allRows;
    }

    public boolean isLargeRoom() {
        return largeRoom;
    }

    public void setLargeRoom(boolean largeRoom) {
        this.largeRoom = largeRoom;
    }

    public void printSeats() {
        Scanner scan = new Scanner(in);
        System.out.println("Enter the number of rows:");
        allRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        allSeats = scan.nextInt();

        displaySeats(false);

    }

    public int calculateProfit() {
        int totalIncome = 0;

        if ((allRows * allSeats) < 60) {
            totalIncome = (allRows * allSeats) * 10;
        } else {
            setLargeRoom(true);
            totalIncome = ((allRows / 2) * allSeats * 10) + ((allRows - (allRows / 2))* allSeats * 8);
        }

        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
        return totalIncome;
    }

    public int setTicketPrice() {
        askForSeatInput();
        int ticketPrice = calculateTicketPrice(row);
        System.out.println("\nTicket price: $" + ticketPrice + "\n");
        return ticketPrice;
    }

    public void printReservedSeats() {
        displaySeats(true);
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
        System.out.println("Enter a row number: ");
        row = scan.nextInt();
        System.out.println("Enter a seat number in that row: ");
        seat = scan.nextInt();
    }

    public int calculateTicketPrice(int selectedRow) {
        checkForLargeRoom();
        if (largeRoom) {
            int halfRows = allRows / 2;
            return (selectedRow <= halfRows) ? 10 : 8;
        }
        return 10;
    }

    public void displaySeats(boolean showReserved) {
        System.out.println("Cinema:");
        for (int i = 0; i <= allSeats; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int i = 1; i <= allRows; i++) {
            for (int j = 0; j <= allSeats; j++) {
                if (j == 0) {
                    System.out.print(i + " ");
                } else if (showReserved && i == row && j == seat) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.printSeats();
//        cinema.calculateProfit();
        cinema.setTicketPrice();
        cinema.printReservedSeats();
    }
}
