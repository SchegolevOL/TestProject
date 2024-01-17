package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Ticket> toJavaObject(String path) {
        List<Ticket> tickets = new ArrayList<>();

        try {
            FileReader reader = new FileReader(path, StandardCharsets.UTF_8);
            System.out.println(reader.getEncoding());
            JSONParser jsonParser = new JSONParser();




            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray lang = (JSONArray) jsonObject.get("tickets");

            for (Object o : lang) {
                JSONObject jsonObjectItem = (JSONObject) o;
                LocalDateTime departureDateTime = formatDataTime(jsonObjectItem.get("departure_date").toString(), jsonObjectItem.get("departure_time").toString());
                LocalDateTime arrivalDateTime = formatDataTime(jsonObjectItem.get("arrival_date").toString(),jsonObjectItem.get("arrival_time").toString());

                Period period = Period.between(departureDateTime.toLocalDate(), arrivalDateTime.toLocalDate());
                Duration duration = Duration.between(departureDateTime.toLocalTime(), arrivalDateTime.toLocalTime());

                Long travelTime =
                        (long) period.getDays() * 24 * 60 +
                                duration.toMinutes();//TODO
                System.out.println("Trevel time "+jsonObjectItem.get("carrier")+"  "+travelTime);
                Ticket ticket = new Ticket(
                        jsonObjectItem.get("carrier").toString(),
                        jsonObjectItem.get("origin_name").toString(),
                        jsonObjectItem.get("destination_name").toString(),
                        departureDateTime,
                        arrivalDateTime,
                        Float.parseFloat(jsonObjectItem.get("price").toString()),
                        travelTime

                );
                tickets.add(ticket);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }
    private static LocalDateTime formatDataTime(String date, String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy kk:mm");
        if (time.charAt(1)==':')time="0"+time;
        return LocalDateTime.parse(date + " " + time, formatter);
    }


}
