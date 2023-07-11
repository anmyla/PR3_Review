package i_Network.Network2_SubmitPostRequest_CheckResponseCode;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ReadServerField {

    public static void main(String[] args) throws IOException {

        // Specify the URL
        String url = "https://google.com";

        // Create a URL object with the specified URL
        URL urlObj = new URL(url);

        // Open a connection to the URL and obtain a URLConnection object
        URLConnection urlCon = urlObj.openConnection();

        // Get the header fields from the URLConnection
        Map<String, List<String>> map = urlCon.getHeaderFields();

        // Iterate over the header fields
        for (String key : map.keySet()) {
            System.out.println(key + ":");

            // Get the values associated with the key
            List<String> values = map.get(key);

            // Iterate over the values and print each one
            for (String aValue : values) {
                System.out.println("\t" + aValue);
            }
        }
    }

    public static void mainNoComments() throws IOException {

        String url = "https://google.com";
        URL urlObj = new URL(url);
        URLConnection urlCon = urlObj.openConnection();

        Map<String, List<String>> map = urlCon.getHeaderFields();


        for (String key : map.keySet()) {
            System.out.println(key + ":");

            List<String> values = map.get(key);

            for (String aValue : values) {
                System.out.println("\t" + aValue);
            }
        }
    }
}
