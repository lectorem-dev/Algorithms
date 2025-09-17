package ru.ya.warm.up;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingReverseOrder {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String baseUrl = reader.readLine().trim();
        int port = Integer.parseInt(reader.readLine().trim());
        int a = Integer.parseInt(reader.readLine().trim());
        int b = Integer.parseInt(reader.readLine().trim());

        // Формируем полный URL
        String fullUrl = String.format("%s:%d?a=%d&b=%d", baseUrl, port, a, b);

        // Делаем GET-запрос
        URL url = new URL(fullUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Читаем ответ
        InputStream inputStream = conn.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        // Парсим JSON
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(response.toString());

        // Переводим в список чисел
        List<Integer> numbers = new ArrayList<>();
        for (Object obj : jsonArray) {
            int value = ((Long) obj).intValue(); // json-simple возвращает Long
            if (value > 0) {
                numbers.add(value);
            }
        }

        // Сортировка по невозрастанию
        numbers.sort(Collections.reverseOrder());

        // Вывод
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
