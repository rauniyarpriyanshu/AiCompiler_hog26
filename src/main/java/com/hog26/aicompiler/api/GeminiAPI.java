package com.hog26.aicompiler.api;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GeminiAPI {
	
    private final String API_KEY = "API_KEY_HERE";
    private String END_POINT = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;
    private GeminiResponse listener;

    public void addResponseListener(GeminiResponse listener) {
        this.listener = listener;
    }

    public void askGemini(String prompt) {
        try {
            HttpURLConnection connection = getHttpURLConnection(prompt);

            int code = connection.getResponseCode();
            listener.onResponseCode(code);
            if (code == HttpURLConnection.HTTP_OK) {

                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    org.json.JSONObject jsonResponse = new org.json.JSONObject(response.toString());
                    String content = jsonResponse
                            .getJSONArray("candidates")
                            .getJSONObject(0)
                            .getJSONObject("content")
                            .getJSONArray("parts")
                            .getJSONObject(0)
                            .getString("text");
                    listener.onSuccess(content);
                }
            } else {
                try (InputStream errorStream = connection.getErrorStream()) {
                    if (errorStream != null) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(errorStream, "utf-8"));
                        StringBuilder errorResponse = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            errorResponse.append(line.trim());
                        }
                        listener.onError(errorResponse.toString());
                    }
                }
            }
        } catch (IOException e) {
            listener.onError(e.toString());
        }


    }

    private HttpURLConnection getHttpURLConnection(String prompt) throws IOException {
        URL url = new URL(END_POINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        String jsonInput = """
                {
                  "contents": [
                    {
                      "role": "user",
                      "parts": [
                        { "text": "%s" }
                      ]
                    }
                  ]
                }
                """.formatted(prompt);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        return connection;
    }

    public interface GeminiResponse {
        void onError(String errorMessage);

        void onSuccess(String response);

        void onResponseCode(int responseCode);
    }
}
