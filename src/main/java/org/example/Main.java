package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String path="C:\\Java Project\\TestProject\\src\\main\\resources\\tickets.json";
    public static void main(String[] args) {
        List<Ticket> tickets = Converter.toJavaObject(path);
        System.out.println(ServiceTicket.medianPrice(tickets));
        System.out.println(tickets);
        System.out.println(ServiceTicket.medianPrice(tickets)+"|" + ServiceTicket.averagePrice(tickets)+" = " + (ServiceTicket.medianPrice(tickets)-ServiceTicket.averagePrice(tickets)));
    }
}