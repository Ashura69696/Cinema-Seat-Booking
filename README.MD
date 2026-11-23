# Cinema Seat Booking – Java HashMap

## Overview
A Java programming assignment demonstrating how to use a `HashMap` with a custom class (`Seat`) as its key and `String` as its value.

The project simulates a cinema seat booking system where customers can book seats, check availability, and handle broken seats.

## Features
- Book cinema seats using `HashMap.put()`.
- Find customers using `HashMap.get()`.
- Check seat availability using `containsKey()`.
- Prevent duplicate bookings using `putIfAbsent()`.
- Remove and update bookings using `remove()`.
- Track broken seats using `HashSet`.
- Count bookings using `size()`.
- Override `equals()` and `hashCode()` to compare custom objects correctly.

## Technologies
- Java
- HashMap
- HashSet
- Object-Oriented Programming

## Project Structure
```text
Cinema-Seat-Booking/
├── Task_CinemaBooking.java
└── README.md
```

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/Ashura69696/Cinema-Seat-Booking.git
```

2. Compile:
```bash
javac Task_CinemaBooking.java
```

3. Run:
```bash
java Task_CinemaBooking
```

## Key Concepts

**equals()**

Compares two Seat objects based on their row and seat number.

**hashCode()**

Generates a hash code based on the row and seat number, ensuring equal seats have the same hash code.

**Why are both necessary?**

HashMap uses `hashCode()` to locate a bucket and `equals()` to compare keys inside that bucket.

## Author

**Ahmed Tarek**

GitHub: [@Ashura69696](https://github.com/Ashura69696)

