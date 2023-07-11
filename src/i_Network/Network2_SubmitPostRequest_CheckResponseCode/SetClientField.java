package i_Network.Network2_SubmitPostRequest_CheckResponseCode;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class SetClientField {
    public static void main(String[] args) throws IOException {

        // Create a URL object with the specified URL
        URL urlObj = new URL("https://www.google.com");

        // Open a connection to the URL and obtain a URLConnection object
        URLConnection urlCon = urlObj.openConnection();

        // Set request properties for the URL connection
        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");
        urlCon.setRequestProperty("Accept", "text/html");
        urlCon.setRequestProperty("Accept-Language", "en-US");
        urlCon.setRequestProperty("Connection", "close");

        // Print the request properties of the URL connection
        //This returns a map where the keys are the header field names and the values are lists of header field values.
        System.out.println(urlCon.getRequestProperties());
    }

    public static void mainNoComment() throws IOException {

        URL urlObj = new URL("https://www.google.com");
        URLConnection urlCon = urlObj.openConnection();

        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");
        urlCon.setRequestProperty("Accept", "text/html");
        urlCon.setRequestProperty("Accept-Language", "en-US");
        urlCon.setRequestProperty("Connection", "close");

        System.out.println(urlCon.getRequestProperties());


    }
}
