package org.example;

public class HotelReservationSystemMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservationSystem reservationSystem = new HotelReservationSystem();
        reservationSystem.addHotels(new Hotel("ABC", 110, 90, 50, 25, 2));
        reservationSystem.addHotels(new Hotel("DEF", 160, 60, 80, 40, 3));
        reservationSystem.addHotels(new Hotel("GHC", 250, 150, 175, 80, 5));

        reservationSystem.showHotels();

        Hotel hotel = reservationSystem.findCheapestBestRatedHotel("10Mar2025", "11Mar2025");
        int totalCost = reservationSystem.calculateTotalCost(hotel, "10Mar2025", "11Mar2025");
        System.out.println("Cheapest hotel is: " + hotel.getHotelName() + " and rating is: " + hotel.getRating() + " the cost is: " + totalCost);

        reservationSystem.findBestRatedHotel("10Mar2025", "11Mar2025");
        reservationSystem.findCheapestBestRatedHotelForRewardCustomer("10Mar2025", "11Mar2025");
        try {
            reservationSystem.findCheapestBestRatedUsingStream("10Mar2025", "11Mar2025", "RWARD");
        } catch (HotelReservationSystemException e) {
            System.out.println(e);
        }
        try {
            Hotel bestHotel = reservationSystem.findCheapestBestRatedHotelForRegularCustomer("10Mar2025","11Mar2025","REGULAR");
            int price = reservationSystem.calculateTotalCost(bestHotel,"10Mar2025","11Mar2025");
            System.out.println("Best Hotel: " + bestHotel.getHotelName()
                    + ", Rating: " + bestHotel.getRating()
                    + ", Total Cost: " + price);

        } catch (HotelReservationSystemException e){
            System.out.println(e);
        }
    }
}
