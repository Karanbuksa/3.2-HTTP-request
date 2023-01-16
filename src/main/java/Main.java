import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build()) {

            HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=we1flFBZSJxcXLg1wNg4JCxxZ4LgMyNMdCRfcOs1");
            CloseableHttpResponse response = httpClient.execute(request);
            NASAObject nasaObject = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
            });
            String pictureURL = nasaObject.getHdurl();
            String[] fileName = pictureURL.split("/");
            response = httpClient.execute(new HttpGet(pictureURL));
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(response.getEntity().getContent());
                 FileOutputStream fileOutputStream = new FileOutputStream(fileName[fileName.length - 1])) {
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    fileOutputStream.write(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
