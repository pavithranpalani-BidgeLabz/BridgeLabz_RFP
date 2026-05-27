package org.example;


public class InvoiceGenerator {

    private final int COST_PER_KM = 10;
    private final int COST_PER_MINUTE = 1;
    private final int MINIMUM_FARE = 5;

    public double calculateFare(double distance,
                                int time) {

        double totalFare =
                (distance * COST_PER_KM)
                        + (time * COST_PER_MINUTE);

        return Math.max(totalFare,
                MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {

        double totalFare = 0;

        for (Ride ride : rides) {

            totalFare +=
                    this.calculateFare(
                            ride.distance,
                            ride.time);
        }

        return totalFare;
    }

    public InvoiceSummary
    calculateInvoiceSummary(Ride[] rides) {

        double totalFare =
                calculateFare(rides);

        return new InvoiceSummary(
                rides.length,
                totalFare);
    }
}
