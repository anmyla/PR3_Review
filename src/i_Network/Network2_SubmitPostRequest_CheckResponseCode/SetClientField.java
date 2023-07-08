package i_Network.Network2_SubmitPostRequest_CheckResponseCode;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class SetClientField {

    public static void main(String[] args) throws IOException {

        URL urlObj = new URL("https://www.google.com");
        URLConnection urlCon = urlObj.openConnection();

        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");
        urlCon.setRequestProperty("Accept", "text/html");
        urlCon.setRequestProperty("Accept-Language", "en-US");
        urlCon.setRequestProperty("Connection", "close");

        System.out.println(urlCon.getRequestProperties());


    }
}
