package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class Ticket {

    private String airCarrier;

    private String departureAirport;

    private String arrivalAirport;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private Float price;

    private Long travelTime;

    @Override
    public String toString() {
        return "Ticket{" +
                "airCarrier='" + airCarrier + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", price=" + price +
                ", travelTime=" + travelTime +
                '}';
    }
}
