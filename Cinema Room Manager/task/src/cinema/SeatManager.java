package cinema;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;

public class SeatManager {
    private static int allRows;
    private static int allSeats;
    private static char[][] seats;
    private static int row;
    private static int seat;

    public static int getRow() {
        return row;
    }

    public static int getSeat() {
        return seat;
    }

    public static int getAllRows() {
        return allRows;
    }

    public static int getAllSeats() {
        return allSeats;
    }

    public static char[][] getSeats() {
        return seats;
    }

    public void askForSeatArrangement() {
        Scanner scan = new Scanner(in);
        while (true) {
            try {
                System.out.println("Enter the number of rows:");
                allRows = scan.nextInt();
                System.out.println("Enter the number of seats in each row:");
                allSeats = scan.nextInt();

                seats = new char[getAllRows()][getAllSeats()];
                for (int i = 0; i < getAllRows(); i++) {
                    for (int j = 0; j < getAllSeats(); j++) {
                        getSeats()[i][j] = 'S';
                    }
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers for rows and seats.");
                scan.nextLine();
            }
        }
    }

    public static void askForSeatInput() {
        Scanner scan = new Scanner(in);

        while (true) {
            try {// Infinite loop
                System.out.println("Enter a row number: ");
                row = scan.nextInt();
                System.out.println("Enter a seat number in that row: ");
                seat = scan.nextInt();

                if (getRow() < 1 || getRow() > getAllRows() || getSeat() < 1 || getSeat() > getAllSeats()) {
                    System.out.println("Wrong input!");
                    continue; // Restart loop
                }


                if (getSeats()[getRow() - 1][getSeat() - 1] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                    continue;  // Restart loop
                }

                getSeats()[getRow() - 1][getSeat() - 1] = 'B';
                break;  // Exit the loop
            } catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter valid integers for row and seat.");
                scan.nextLine();
            }
        }
    }

    public static void displaySeats() {
        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 1; i <= getAllSeats(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < getAllRows(); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < getAllSeats(); j++) {
                System.out.print(getSeats()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
