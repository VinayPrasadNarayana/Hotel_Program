/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelprogram;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author vinay
 */
public class HotelProgram {

    String[] hotel = new String[11];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);
        Scanner exit = new Scanner(System.in);
        Scanner delete = new Scanner(System.in);
        Scanner find = new Scanner(System.in);
        //First get the names for your input and output files
        Scanner console = new Scanner(System.in);
        int exit1;
        String[] hotel = new String[11];
        initialise(hotel); //better to initialise in a procedure
        System.out.println("Press 1 to enter the menu.");
        exit1 = exit.nextInt();
        int len = hotel.length;
        while (exit1 != 11) {

            System.out.println("Enter 'V' to view all rooms ");
            System.out.println("Enter 'A' to add customer to a room");
            System.out.println("Enter 'E' to to view all empty rooms");
            System.out.println("Enter 'D' to delete customer from the room");
            System.out.println("Enter 'F' to find the room number of the customer");
            System.out.println("Enter 'O' to arrange the rooms in assending order");
            System.out.println("Enter 'L' to load data");
            System.out.println("Enter 'S' to save data");
            System.out.println("Enter 'Q' to exit the menu");
            String menu = in.next();
            char menu1 = menu.charAt(0);
            if (menu1 == 'Q') {
                exit1 = 11;
                continue;
            }
            switch (menu) {

                case "A": {

                    ADD(hotel);
                    break;
                }
                case "V": {

                    View(hotel);
                    break;
                }
                case "E": {

                    Empty(hotel);
                    break;
                }
                case "D": {

                    DELETE(hotel);
                    break;
                }
                case "F": {

                    Find(hotel);
                    break;
                }
                case "L": {

                    LoadFile(hotel);
                    break;
                }
                case "S": {

                    StoreFile(hotel);
                    break;
                }
                case "O": {

                    Arrange(hotel);
                    break;
                }
            }
        }
    }

    private static void initialise(String hotelRef[]) {
        for (int x = 0; x < 10; x++) {
            hotelRef[x] = "e";
        }
        System.out.println("initilise ");
    }

    private static void View(String hotel[]) {
        for (int x = 0; x < 10; x++) {
            System.out.println("Room " + x + " occupied by " + hotel[x]);
        }
    }

    private static void Empty(String hotel[]) {
        for (int x = 0; x < 10; x++) {
            if (hotel[x].equals("e")) {
                System.out.println("Room " + x + " is empty");
            }
        }
    }

    private static void ADD(String hotel[]) {
        Scanner input = new Scanner(System.in);
        String roomName = null;
        int roomNum = 0;
        while (roomNum < 10) {
            for (int x = 0; x < 10; x++) {
                if (hotel[x].equals("e")) {
                    System.out.println("Room " + x + " is empty");
                }
            }
            System.out.println("Enter room number (0-9) or 10 to stop:");
            roomNum = input.nextInt();
            if (roomNum == 10) {
                continue;
            }
            System.out.println("Enter name for room " + roomNum + " :");
            roomName = input.next();
            hotel[roomNum] = roomName;
            for (int x = 0; x < 10; x++) {
                System.out.println("Room " + x + " occupied by " + hotel[x]);
            }
        }
    }

    private static void DELETE(String hotel[]) {
        Scanner delete = new Scanner(System.in);
        for (int x = 0; x < 10; x++) {
            System.out.println("Room " + x + " occupied by " + hotel[x]);
        }
        int delete1;
        int x;
        System.out.println("Select the room");
        delete1 = delete.nextInt();
        x = delete1;
        hotel[x] = "e";

    }

    private static void Find(String hotel[]) {
        Scanner find = new Scanner(System.in);
        String find1;
        System.out.println("Enter the name of the customer:");
        find1 = find.next();
        for (int x = 0; x < 10; x++) {
            // System.out.println("Room " + x + " occupied by " + hotel[x]);
            if (find1.equals(hotel[x])) {
                System.out.println("The customer " + hotel[x] + " is in the room " + x);
            }
        }

    }

    private static void LoadFile(String hotel[]) throws IOException {
        Scanner console = new Scanner(System.in);

        int linecount = 0;
        System.out.println("Input file name: ");
        String inputFileName = console.next();
        String fileLine;
        Scanner in = new Scanner(new File(inputFileName));
        while (in.hasNext()) {
            fileLine = in.nextLine();
            hotel[linecount] = fileLine;
            System.out.println(linecount + " " + fileLine);
            linecount++;
        }
        in.close();
    }

    private static void StoreFile(String hotel[]) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Output file: ");
        String outputFileName = console.next();
        try (PrintWriter outputFile = new PrintWriter(outputFileName)) {
            for (int j = 0; j < 10; j++) {
                outputFile.println(hotel[j]);
            }
        }
    }

    private static void Arrange(String hotel[]) {
        String[] hotelcopy = new String[11];
        for (int x = 0; x < 10; x++) {
            hotelcopy[x] = hotel[x];
        }
        int n = 10;
        int k = 1; // number of transversals
        int j = n - 2; //last but one element 
        while (k < n) {
            int i = 0;
            while (i <= j) {
                if (hotelcopy[i].compareTo(hotelcopy[i + 1]) > 0) {
                    String temp = hotelcopy[i];
                    hotelcopy[i] = hotelcopy[i + 1];
                    hotelcopy[i + 1] = temp;
                }
                i++;

            }
            k++;

        }
        for (int x = 0; x < 10; x++) {
            System.out.println(hotelcopy[x]);

        }

    }

}
