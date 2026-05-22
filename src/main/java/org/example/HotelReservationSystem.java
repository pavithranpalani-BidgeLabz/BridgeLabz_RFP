package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservationSystem {
    List<Hotel> hotels = new ArrayList<>();

    public void addHotels(Hotel hotel) {
        hotels.add(hotel);
        System.out.println("Hotel added successfully: " + hotel.getHotelName());
    }

    public void showHotels() {
        if (hotels.isEmpty()) {
            System.out.println("No hotels are available!!");
            return;
        }
        System.out.println("Available Hotels list are:  ");
        hotels.forEach(System.out::println);
    }

    public void findCheapestHotel(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");

        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        int weekDaysCount = 0;
        int weekendDaysCount = 0;

        LocalDate date = start;

        while (!date.isAfter(end)) {
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                weekendDaysCount++;
            } else {
                weekDaysCount++;
            }
            date = date.plusDays(1);
        }

        int cheapPrice = Integer.MAX_VALUE;
        String cheapHotelName = "";

        for (Hotel hotel : hotels) {

            int totalCostOfHotel = (hotel.getWeekdayRate() * weekDaysCount) + (hotel.getWeekendRate() * weekendDaysCount);

            if (totalCostOfHotel < cheapPrice) {
                cheapPrice = totalCostOfHotel;
                cheapHotelName = hotel.getHotelName();
            }
        }
        System.out.println("Cheapest Hotel is : " + cheapHotelName + " and the price is: " + cheapPrice);
    }

    public Hotel findCheapestBestRatedHotel(String startDate, String endDate) {
        return hotels.stream()
                .min(
                        Comparator.comparingInt((Hotel h) ->
                                        calculateTotalCost(h, startDate, endDate))
                                .thenComparing(Hotel::getRating, Comparator.reverseOrder())
                )
                .orElse(null);
    }

    public int calculateTotalCost(Hotel hotel, String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        int total = 0;
        LocalDate date = start;

        while (!date.isAfter(end)) {
            DayOfWeek day = date.getDayOfWeek();

            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                total += hotel.getWeekendRate();
            else
                total += hotel.getWeekdayRate();

            date = date.plusDays(1);
        }
        return total;
    }

    public void findBestRatedHotel(String startDate, String endDate) {
        Hotel hotel = hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
        System.out.println("Best rated hotel is: " + hotel.getHotelName() + " and rating is: " + hotel.getRating() + " and the cost is: " + calculateTotalCost(hotel, startDate, endDate));
    }

    public void findCheapestBestRatedHotelForRewardCustomer(String startDate, String endDate) {
        Hotel hotel = hotels.stream()
                .max(Comparator.comparingInt((Hotel h) -> calculateRewardCost(h, startDate, endDate))
                        .thenComparing(Hotel::getRating).reversed())
                .orElse(null);
        System.out.println("Best reward hotel is: " + hotel.getHotelName() + " Rating: " + hotel.getRating() + " cost is: " + calculateRewardCost(hotel, startDate, endDate));
    }

    private int calculateRewardCost(Hotel hotel, String startDate, String endDate) {
        int total = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        LocalDate date = start;

        while (!date.isAfter(end)) {
            DayOfWeek day = date.getDayOfWeek();

            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                total += hotel.getRewardWeekendRate();
            else
                total += hotel.getRewardWeekdayRate();

            date = date.plusDays(1);
        }
        return total;
    }

    public void findCheapestBestRatedUsingStream(String startDate, String endDate, String reward) throws HotelReservationSystemException {
        validateInput(startDate, endDate, reward);

        Hotel hotel = hotels.stream()
                .min(Comparator.comparingInt((Hotel h) -> calculateRewardCost(h, startDate, endDate))
                        .thenComparing(Hotel::getRating).reversed())
                .orElseThrow(() -> new HotelReservationSystemException("No Hotels Found"));

        System.out.println("Best reward hotel is: " + hotel.getHotelName() + " Rating: " + hotel.getRating() + " cost is: " + calculateRewardCost(hotel, startDate, endDate));

    }

    private void validateInput(String startDate, String endDate, String reward) throws HotelReservationSystemException {
        if (startDate == null || endDate == null || reward == null) {
            throw new HotelReservationSystemException("Input can't be null.");
        }
        if (!reward.equalsIgnoreCase("REWARD")) {
            throw new HotelReservationSystemException("Only REWARD customer allowed!!");
        }
        String dateRegex = "^[0-9]{2}[A-Za-z]{3}[0-9]{4}$";
        if (!startDate.matches(dateRegex) || !endDate.matches(dateRegex)) {
            throw new HotelReservationSystemException("Invalid Date format (use only ddMMyyyy)");
        }

    }

    public Hotel findCheapestBestRatedHotelForRegularCustomer(String startDate, String endDate, String customerType) throws HotelReservationSystemException {
        validateInputRegular(startDate, endDate, customerType);
        return hotels.stream()
                .min(Comparator.comparingInt((Hotel h) -> calculateTotalCost(h, startDate, endDate))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .orElseThrow(() -> new HotelReservationSystemException("No Hotels Available"));
    }

    private void validateInputRegular(String startDate, String endDate, String customerType) throws HotelReservationSystemException {

        if (customerType == null || startDate == null || endDate == null)
            throw new HotelReservationSystemException("Input cannot be null");

        if (!customerType.equalsIgnoreCase("REGULAR"))
            throw new HotelReservationSystemException("Only REGULAR customer allowed");

        String dateRegex = "^[0-9]{2}[A-Za-z]{3}[0-9]{4}$";

        if (!startDate.matches(dateRegex) || !endDate.matches(dateRegex))
            throw new HotelReservationSystemException("Invalid Date Format (Use ddMMyyyy)");
    }

}
