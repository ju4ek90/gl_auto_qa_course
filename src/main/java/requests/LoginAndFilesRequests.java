package requests;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import utils.CommonUtils;
import utils.SendRequest;

import java.io.IOException;

public class LoginAndFilesRequests {

    private static final String REQUEST_HOST = "app.cosmosid.com"; //можна потім винести до aplication.proprty файлу.
    private static final String PARAM_URL = "api";
    private static final String PARAM_URL_1 = "v1";
    private static final String PARAM_URL_2 = "login";
    private static final String AUTH = "Basic bWFpbGludGVzdEB1a3IubmV0Om1haWxpbnRlc3RAdWtyLm5ldA==";

    private static String token;

    public static void main(String[] args) {
        sendLoginRequestToUr();
//        filesRootFolderRequest();
//        filesSpecificFolderRequest();
//        filesRootFolderRequest();
//        filesSpecificFolderRequest();
//        filesCountRequest();
//        filesResultsGetRunsRequest();
//        filesResultsGetAnalysesRequest();
        filesResultsGetArtifactsRequest();
    }

    private static final OkHttpClient client = new OkHttpClient();

    public static String sendLoginRequestToUr() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment(PARAM_URL_1)
                .addPathSegment(PARAM_URL_2)
                .build();


        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "Authorization", AUTH);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " for " + response.request().url());
            token = CommonUtils.getToken(response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
        return token;
    }

    public static void filesRootFolderRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment("v2")
                .addPathSegment("files?breadcrumbs=1&offset=0&limit=1000&_=1622700773180")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static void filesSpecificFolderRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment("v2")
                .addPathSegment("files?breadcrumbs=1&offset=0&limit=1000&folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773180")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static void filesCountRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment(PARAM_URL_1)
                .addPathSegment("files")
                .addPathSegment("count?folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773179")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static void filesResultsGetRunsRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment(PARAM_URL_1)
                .addPathSegment("files")
                .addPathSegment("7f4c7326-0a4e-4b56-a8d0-8ce002191672/runs?_=1622700773181")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static void filesResultsGetAnalysesRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment(PARAM_URL_1)
                .addPathSegment("runs")
                .addPathSegment("437ef8e4-b595-4fd8-a2f5-64221831e925/analysis?filter=total&_=1622700773184")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }

    public static void filesResultsGetArtifactsRequest() {

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(REQUEST_HOST)
                .addPathSegment(PARAM_URL)
                .addPathSegment("metagenid")
                .addPathSegment(PARAM_URL_1)
                .addPathSegment("runs")
                .addPathSegment("437ef8e4-b595-4fd8-a2f5-64221831e925/artifacts?_=1622700773185")
                .build();

        //Create request
        Request request = SendRequest
                .buildRequestWithHeader(url, "x-token", token);

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Status code is " + response.code() + " Response is: " + response.body().string().toString());
        } catch (IOException e) {
            System.out.println("Error. Incorrect host or some else parameters. Any response was get");
        }
    }
}
