package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceTicket {
    public static Float medianPrice(List<Ticket> tickets){
        List<Float> prices = new ArrayList<>();
        for (Ticket ticket:tickets) {
            prices.add(ticket.getPrice());
        }
        Collections.sort(prices);
        return prices.get(prices.size()/2);
    }
    public static Float averagePrice(List<Ticket>tickets){
        Float price= 0.0F;
        for (Ticket ticket:tickets) {
            price += ticket.getPrice();
        }
        return price/tickets.size();
    }
}
