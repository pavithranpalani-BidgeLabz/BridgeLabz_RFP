package org.example;

public class Hotel {
    private String hotelName;
    private int weekdayRate;
    private int weekendRate;
    private int rewardWeekdayRate;
    private int rewardWeekendRate;
    private int rating;

    public Hotel(String hotelName, int weekdayRate, int weekendRate, int rewardWeekdayRate, int rewardWeekendRate, int rating) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRewardWeekdayRate() {
        return rewardWeekdayRate;
    }

    public void setRewardWeekdayRate(int rewardWeekdayRate) {
        this.rewardWeekdayRate = rewardWeekdayRate;
    }

    public int getRewardWeekendRate() {
        return rewardWeekendRate;
    }

    public void setRewardWeekendRate(int rewardWeekendRate) {
        this.rewardWeekendRate = rewardWeekendRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayRate=" + weekdayRate +
                ", weekendRate=" + weekendRate +
                ", rewardWeekdayRate=" + rewardWeekdayRate +
                ", rewardWeekendRate=" + rewardWeekendRate +
                ", rating=" + rating +
                '}';
    }
}
