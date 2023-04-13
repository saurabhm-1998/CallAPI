import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCall {
    public static void main(String[] args) throws IOException {
        String apiUrl = "https://api.zippopotam.us/us/33162";

        URL url = new URL("https://api.zippopotam.us/us/33162");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine = null;
            StringBuffer jsonResponseData = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                jsonResponseData.append(inputLine);
            }

            in.close();


            System.out.println(jsonResponseData.toString());
        }else{
            System.out.println(responseCode);
        }
    }
}
