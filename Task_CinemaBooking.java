
import java.util.*;

class Task_CinemaBooking {

    static class Seat {
        final char row;
        final int number;

        Seat(char row, int number) {
            this.row = row;
            this.number = number;
        }

        @Override
        public String toString() {
            return "" + row + number;
        }

        // TODO 1: Override equals()
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Seat seat = (Seat) o;

            return row == seat.row && number == seat.number;
        }

        // TODO 2: Override hashCode()
        @Override
        public int hashCode() {
            return Objects.hash(row, number);
        }
    }

    public static void main(String[] args) {

        // Key = Seat, Value = customer name
        HashMap<Seat, String> bookings = new HashMap<>();
        HashSet<Seat> broken = new HashSet<>();

        // Part A: Book seats
        bookings.put(new Seat('A', 1), "Ali");
        bookings.put(new Seat('A', 2), "Sara");
        bookings.put(new Seat('B', 5), "Omar");
        bookings.put(new Seat('C', 3), "Mona");

        System.out.println("Bookings:           " + bookings);

        // Part B: Who booked C3?
        System.out.println("Who booked C3:      "
                + bookings.get(new Seat('C', 3)));

        // Part C: Are seats A2 and E6 taken?
        System.out.println("Is A2 taken:        "
                + bookings.containsKey(new Seat('A', 2)));

        System.out.println("Is E6 taken:        "
                + bookings.containsKey(new Seat('E', 6)));

        // Part D: Youssef wants B5
        String existingCustomer =
                bookings.putIfAbsent(new Seat('B', 5), "Youssef");

        if (existingCustomer == null) {
            System.out.println("Youssef -> B5:      booked");
        } else {
            System.out.println("Youssef -> B5:      refused, taken by "
                    + existingCustomer);
        }

        // Part E: Ali moves from A1 to D2
        bookings.remove(new Seat('A', 1));
        bookings.put(new Seat('D', 2), "Ali");

        System.out.println("After Ali moved:    " + bookings);

        // Part F: Broken seats
        broken.add(new Seat('E', 1));
        broken.add(new Seat('E', 2));

        if (broken.contains(new Seat('E', 1))) {
            System.out.println("Hana -> E1:         refused, seat is broken");
        } else {
            bookings.put(new Seat('E', 1), "Hana");
            System.out.println("Hana -> E1:         booked");
        }

        // Part G: Number of booked seats
        System.out.println("Seats booked:       " + bookings.size());

        // Seating chart - DO NOT CHANGE
        System.out.println();
        printChart(bookings, broken);
    }

    // GIVEN - do not change
    static void printChart(HashMap<Seat, String> bookings,
                           HashSet<Seat> broken) {

        System.out.println("     1  2  3  4  5  6");

        for (char row = 'A'; row <= 'E'; row++) {
            System.out.print(row + "  ");

            for (int number = 1; number <= 6; number++) {
                Seat seat = new Seat(row, number);

                if (bookings.containsKey(seat)) {
                    System.out.print("  X");
                } else if (broken.contains(seat)) {
                    System.out.print("  #");
                } else {
                    System.out.print("  .");
                }
            }

            System.out.println();
        }
    }
}

/*
QUESTIONS - ANSWERS

Q1. Why did we have to override hashCode() and equals()?

Because Seat is a custom class, Java does not automatically
compare its objects based on row and number.

equals() checks whether two Seat objects represent the same seat.

hashCode() ensures that equal Seat objects return the same hash code,
allowing HashMap and HashSet to find them correctly.


Q2. Delete hashCode() but keep equals(). What happens? Why?

The program may give incorrect results.

HashMap uses hashCode() to find the correct bucket before
using equals() to compare objects.

Without overriding hashCode(), equal Seat objects may have
different hash codes.


Q3. Why are row and number final?

Because a seat's identity should not change after creation.

If row or number changes after inserting the object into
a HashMap, its hash code may change, and the map may no
longer be able to find the object correctly.


Q4. Change equals(Object o) to equals(Seat o).
Then remove @Override. What happens?

Java treats equals(Seat o) as an overloaded method,
not an overridden method.

HashMap calls equals(Object o), so the custom comparison
will not be used. The program may produce incorrect results.


BONUS. Replace Seat class with:

record Seat(char row, int number) {}

The program works correctly because Java records automatically
generate equals(), hashCode(), and toString() based on their fields.
*/
