package RestAPI_JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

//출처: https://miniweb4u.tistory.com/25


public class RestAPI_ObjectMapper {
    public static void main(String[] args) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("DATA", "Test1");    //파라미터 설정
        ObjectMapper mapper = new ObjectMapper();
        String json = null;    //convert map to JSON String(JSON으로 변환)
        try {
            json = mapper.writeValueAsString(resultMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //GET
        String msgGet = getREST("https://httpbin.org/get");
        System.out.println(msgGet);

        //POST
//        String msgPost = sendREST("https://httpbin.org/post", json);
//        System.out.println(msgPost);

        /* JsonStr -> Map */
        System.out.println("\n1. JsonStr -> Map");
        try {
            Map<String, Object> tempMapper1 = mapper.readValue(msgGet, new TypeReference<Map<String, Object>>() { });
            System.out.println(tempMapper1);
            String headersContent = mapper.writeValueAsString(tempMapper1.get("headers"));
            Map<String, Object> tempMapper2 = mapper.readValue(headersContent, new TypeReference<Map<String, Object>>() { });
            System.out.println(headersContent);
            System.out.println(tempMapper2.get("Accept"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static String sendREST(String sendUrl, String jsonValue) throws IllegalStateException {
        String inputLine = null;
        StringBuilder outResult = new StringBuilder();

        try{
            System.out.println(("REST API Start"));
            URL url = new URL(sendUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            OutputStream os = conn.getOutputStream();
            os.write(jsonValue.getBytes(StandardCharsets.UTF_8));
            os.flush();

            System.out.println(os);

            // 리턴된 결과 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            while ((inputLine = in.readLine()) != null) {
                outResult.append(inputLine);
            }

            conn.disconnect();
            System.out.println(("REST API End"));
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return outResult.toString();
    }

    public static String getREST(String sendUrl) throws IllegalStateException {
        String inputLine = null;
        StringBuilder outResult = new StringBuilder();

        try{
            System.out.println(("REST API Start"));
            URL url = new URL(sendUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 리턴된 결과 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            while ((inputLine = in.readLine()) != null) {
                outResult.append(inputLine);
            }

            conn.disconnect();
            System.out.println(("REST API End"));
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return outResult.toString();
    }
}

class VO{
    private String args;
    private String origin;
    private String url;
}
