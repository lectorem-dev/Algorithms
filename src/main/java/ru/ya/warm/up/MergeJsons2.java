package ru.ya.warm.up;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MergeJsons2 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        JSONParser parser = new JSONParser();
        JSONArray allOffers = new JSONArray();

        for (int i = 0; i < n && allOffers.size() < m; i++) {
            JSONObject feed = (JSONObject) parser.parse(reader.readLine());
            JSONArray offers = (JSONArray) feed.get("offers");

            for (Object offerObj : offers) {
                if (allOffers.size() >= m) break;
                allOffers.add(offerObj);
            }
        }

        JSONObject result = new JSONObject();
        result.put("offers", allOffers);
        writer.write(result.toJSONString());

        reader.close();
        writer.close();
    }
}
