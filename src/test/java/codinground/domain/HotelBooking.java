package codinground.domain;

import java.util.Date;

public class HotelBooking {
    public enum Travellers {
        ONE_ROOM_ONE_ADULT("1 room, 1 adult"),
        ONE_ROOM_TWO_ADULTS("1 room, 2 adults"),
        TWO_ROOM_TWO_ADULTS("2 rooms, 2 adults"),
        MORE_TRAVELLERS("More travellers...");

        Travellers(String text) {
            this.text = text;
        }

        public String text;
    }

    private final String locality;
    private final Travellers travellers;
    private final Date checkin;
    private final Date checkout;


    public HotelBooking(String locality, Travellers travellers, Date checkin, Date checkout) {
        this.locality = locality;
        this.travellers = travellers;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getLocality() {
        return locality;
    }

    public Travellers getTravellers() {
        return travellers;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
}
