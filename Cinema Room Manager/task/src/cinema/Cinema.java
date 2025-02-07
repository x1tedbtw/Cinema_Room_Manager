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
        System.out.println("Cinema:");
        for (int i = 0; i < 9; i++){
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int row = 1; row <=7; row++){
            for (int seat = 0; seat <= 8; seat++){
                if (seat == 0){
                    System.out.print(row + " ");
                } else {
                    System.out.print("S ");
                }

            }
            System.out.println();
        }
    }

    public int calculateProfit() {
        int totalIncome = 0;
        Scanner scan = new Scanner(in);
        System.out.println("Enter the number of rows:");
        allRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        allSeats = scan.nextInt();

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
        int ticketPrice = 0;
        Scanner scan = new Scanner(in);
        System.out.println("Enter the row number: ");
        row = scan.nextInt();
        System.out.println("Enter a seat number in that row: ");
        seat = scan.nextInt();

        if (largeRoom) {
            int halfRows = (int) Math.ceil(getAllRows() / 2.0);
            if (row <= halfRows) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        else {
            ticketPrice = 10;
        }

        System.out.print("Ticket price: $" + ticketPrice);

        return ticketPrice;
    }

    public void printReservedSeats() {
        // Create a list to "visualize" cinema
        // Change the S to B where needed in the list

    }


    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.printSeats();
        cinema.calculateProfit();
        cinema.setTicketPrice();
    }
}
