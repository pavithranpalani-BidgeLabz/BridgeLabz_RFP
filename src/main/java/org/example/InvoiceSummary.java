package org.example;

public class InvoiceSummary {

    int numberOfRides;
    double totalFare;
    double averageFarePerRide;

    public InvoiceSummary(int numberOfRides,
                          double totalFare) {

        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide =
                this.totalFare / this.numberOfRides;
    }

    @Override
    public String toString() {

        return "InvoiceSummary{" +
                "numberOfRides=" + numberOfRides +
                ", totalFare=" + totalFare +
                ", averageFarePerRide=" +
                averageFarePerRide +
                '}';
    }
}