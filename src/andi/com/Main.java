package andi.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8,12);

        // shadow copy ... if we modify a seat, changes in one are reflected in the other list => see below
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        // two reference to the same object reference
        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        // they are two separate array list refering to the same object
        Collections.reverse(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);

        /*theatre.getSeats();

        if(theatre.reserveSeat("H11"))
            System.out.println("Please pay");
        else
            System.out.println("Sorry seat is taken");
*/


    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("================================================================");
    }
}
