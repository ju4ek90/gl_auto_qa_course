package utils;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;
import java.net.URL;

public class SendRequest {

    private static final String REQUEST_HOST = "inweb.ua"; //можна потім винести до aplication.proprty файлу.
    private static final String PARAM_URL = "seo";

    public static void main(String[] args) {
        sendRequestToUrl();
    }

    private static final OkHttpClient client = new OkHttpClient();

    public static void sendRequestToUrl() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .build();

        client.setFollowRedirects(false);

        //Create request
        Request request = buildRequest(url);

        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 301) {
                System.out.println("Status code is " + response.code() + " for " + response.request().url() + " Redirect to " + response.header("location"));
                url = HttpUrl.get(new URL(response.header("location")));
                response = client.newCall(buildRequest(url)).execute();
            }
            System.out.println("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static Request buildRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .build();
    }
}
