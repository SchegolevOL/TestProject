package org.example;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static final String path = "C:\\Java Project\\TestProject\\src\\main\\resources\\1.json";

    public static void main(String[] args) {


        List<Ticket> tickets = Converter.toJavaObject(path);
        System.out.println(tickets);
        System.out.println(ServiceTicket.differenceBetweenAveragePriceMedianPriceVladivostokTelAviv(tickets));
        System.out.println(ServiceTicket.minTravelTimeVladivostokTelAviv(tickets));

    }
}