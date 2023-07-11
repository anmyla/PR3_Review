package i_Network.Network2_SubmitPostRequest_CheckResponseCode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckResponseCode {

    public static void main(String[] args) throws IOException {

        // Create a URL object with the specified URL
        URL urlObj = new URL("https://www.google.com");

        // Open a connection to the URL and cast it to HttpURLConnection
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        // Get the HTTP response code from the connection
        int responseCode = httpCon.getResponseCode();

        // Check the response code
        if (responseCode != HttpURLConnection.HTTP_OK) {
            // If the response code is not HTTP_OK (200), print an error message
            System.out.println("Server returned response code " + responseCode + ". Download failed.");
        } else {
            // If the response code is HTTP_OK (200), print the response code
            System.out.println(responseCode);
        }
    }

    public static void main1NoComments() throws IOException {

        URL urlObj = new URL("https://www.google.com");
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        int responseCode = httpCon.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Server returned response code " + responseCode + ". Download failed.");
        }
        else {
            System.out.println(responseCode);
        }

    }
}

