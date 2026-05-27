package org.example;

public class Main {

    public static void main(String[] args) {

        InvoiceGenerator generator =
                new InvoiceGenerator();

        // UC1
        double fare =
                generator.calculateFare(2.0, 5);

        System.out.println(
                "Single Ride Fare : "
                        + fare);

        // UC2
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(3.0, 10)
        };

        double totalFare =
                generator.calculateFare(rides);

        System.out.println(
                "Total Fare : "
                        + totalFare);

        // UC3
        InvoiceSummary summary =
                generator.calculateInvoiceSummary(
                        rides);

        System.out.println(summary);
    }
}