package ru.ya.warm.up;

// https://coderun.yandex.ru/problem/merge-jsons-2/analyses/2737 мой разбор ради мема :D

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MergeJsons2 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(firstLine[0]); // количество фидов
        int m = Integer.parseInt(firstLine[1]); // максимум офферов в итоговом фиде

        JSONParser parser = new JSONParser();
        JSONArray resultOffers = new JSONArray();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            JSONObject feed = (JSONObject) parser.parse(line);
            JSONArray offers = (JSONArray) feed.get("offers");

            for (Object offer : offers) {
                if (resultOffers.size() < m) {
                    //noinspection unchecked
                    resultOffers.add(offer);
                } else {
                    break; // достигли лимита m
                }
            }
        }

        JSONObject resultFeed = new JSONObject();
        //noinspection unchecked
        resultFeed.put("offers", resultOffers);

        System.out.println(resultFeed.toJSONString());
    }
}
