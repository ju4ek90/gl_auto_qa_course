package utils;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;

public class SendRequest {

    public static void main(String[] args) {
        sendRequestToUrl();
    }


    private static final OkHttpClient client = new OkHttpClient();

    public static void sendRequestToUrl() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("google.com")
                .build();

        Request request = buildRequest(url);

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.code());
            System.out.println(response.request().url());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static Request buildRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .build();
    }
}
