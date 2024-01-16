package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Ticket> toJavaObject(String path) {
        List<Ticket> tickets = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            FileReader reader = new FileReader(path);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray lang = (JSONArray) jsonObject.get("tickets");

            for (Object o : lang) {
                JSONObject jsonObjectItem = (JSONObject) o;
                LocalDateTime departureDateTime = LocalDateTime.parse(jsonObjectItem.get("departureDateTime").toString(), formatter);
                LocalDateTime arrivalDateTime = LocalDateTime.parse(jsonObjectItem.get("arrivalDateTime").toString(), formatter);
                Period period = Period.between(departureDateTime.toLocalDate(), arrivalDateTime.toLocalDate());
                Duration duration = Duration.between(departureDateTime.toLocalTime(), arrivalDateTime.toLocalTime());

                Long travelTime =
                        (long) period.getDays() * 24 * 60 +
                                duration.toMinutes() -
                                (Long.parseLong(jsonObjectItem.get("arrivalAirportUTC").toString()) * 60 - Long.parseLong(jsonObjectItem.get("departureAirportUTC").toString()) * 60);
                System.out.println(travelTime);
                Ticket ticket = new Ticket(
                        jsonObjectItem.get("airCarrier").toString(),
                        jsonObjectItem.get("departureAirport").toString(),
                        jsonObjectItem.get("arrivalAirport").toString(),
                        departureDateTime,
                        arrivalDateTime,
                        Float.parseFloat(jsonObjectItem.get("price").toString()),
                        travelTime

                );
                tickets.add(ticket);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }
}
