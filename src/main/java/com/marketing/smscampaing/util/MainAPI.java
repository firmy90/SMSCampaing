package com.marketing.smscampaing.util;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
// TODO Dlaczego to nie jest serwis?
// TODO Dlaczego nie użyjemy HttpClient?
// TODO Przejść na asynchroniczną wysyłkę: Eveny lub JMS (np. RabitMQ)
public class MainAPI {


    public static int sendMessagesToClient(String url, String to, String content, String auth) throws IOException {

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(to);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        jsonObject.put("to", jsonArray);


        URL providerUrl = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) providerUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", auth);
        connection.setDoInput(true);
        connection.setDoOutput(true);


        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(jsonObject.toString());
        out.close();

        new InputStreamReader(connection.getInputStream());
        int code = connection.getResponseCode();
        log.debug("sendMessagesToClient: Phone number: {}, Code of sending messages:{}", to, code);

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                            .build(),
                    HttpResponse.BodyHandlers.ofString());
            code = response.statusCode();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return code;

    }


}
