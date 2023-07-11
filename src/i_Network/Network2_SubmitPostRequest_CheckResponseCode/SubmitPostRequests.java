package i_Network.Network2_SubmitPostRequest_CheckResponseCode;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitPostRequests {

    public static void main(String[] args) {

        // Specify the URL, email, and password
        String url = "https://twitter.com/sessions";
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            // Create a URL object with the specified URL
            URL urlObj = new URL(url);

            // Open a connection to the URL and cast it to HttpURLConnection
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            // Set the request method to "POST"
            httpCon.setRequestMethod("POST");

            // Set the request parameters
            String parameters = "username=" + email;
            parameters += "password=" + password;

            // Write the parameters to the output stream of the connection
            OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();

            // Print the response code from the connection
            System.out.println(httpCon.getResponseCode());

        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }

    public static void mainNoComment() {

        String url = "https://twitter.com/sessions";
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            URL urlObj = new URL(url);

            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

//            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            String parameters = "username=" + email;
            parameters += "password=" + password;

            OutputStreamWriter writer = new OutputStreamWriter(
                    httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();

            System.out.println(httpCon.getResponseCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
