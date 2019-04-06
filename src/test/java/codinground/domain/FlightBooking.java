package codinground.domain;

import java.util.Date;

public class FlightBooking {
    private final String source;
    private final String destination;
    private final Date departDate;

    public FlightBooking(String source, String destination, Date departDate) {
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartDate() {
        return departDate;
    }

}
