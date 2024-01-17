package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static final String PATH = "C:\\Java Project\\";

    public static void main(String[] args) {

        Path myPath = Paths.get(PATH, "testproject", "src", "main", "resources", "tickets.json");



        List<Ticket> tickets = Converter.toJavaObject(myPath.toString());
        System.out.println(tickets);
        System.out.println(ServiceTicket.differenceBetweenAveragePriceMedianPriceVladivostokTelAviv(tickets));
        System.out.println(ServiceTicket.minTravelTimeVladivostokTelAviv(tickets));

    }
}