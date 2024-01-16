package org.example;

import java.util.*;

public class ServiceTicket {


    public static Float differenceBetweenAveragePriceMedianPriceVladivostokTelAviv(List<Ticket> tickets) {
        List<Float> medianPrice = new ArrayList<>();
        Float averagePrice = 0.0F;
        int i =0;
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureAirport().equals("Владивосток") && ticket.getArrivalAirport().equals("Тель-Авив")){
                medianPrice.add(ticket.getPrice());
                averagePrice+=ticket.getPrice();
                i++;
            }
        }
        averagePrice = averagePrice/i;
        Collections.sort(medianPrice);
        return medianPrice.get(i/2)-averagePrice;
    }

    public static HashMap<String, Long> minTravelTimeVladivostokTelAviv(List<Ticket> tickets) {
        HashMap<String, Long> minTravelTime = new HashMap<>();
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureAirport().equals("Владивосток") && ticket.getArrivalAirport().equals("Тель-Авив")){
                System.out.println(ticket.getAirCarrier()+"----"+ticket.getTravelTime());
                if (!minTravelTime.containsKey(ticket.getAirCarrier())) {
                    minTravelTime.put(ticket.getAirCarrier(), ticket.getTravelTime());
                } else if (ticket.getTravelTime() < minTravelTime.get(ticket.getAirCarrier())) {
                    minTravelTime.put(ticket.getAirCarrier(), ticket.getTravelTime());
                }
        }

        }
        return minTravelTime;
    }
}
