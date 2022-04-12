package utils;

public class CommonUtils {

    public static String getToken(String response) {
        String token = response.split("token\":")[1];
        token = token.replaceAll("\"", "");
        token = token.replaceAll("}", "").trim();
        return token;
    }
}
