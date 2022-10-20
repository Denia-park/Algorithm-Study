package RestAPI_JSON;

// Jackson Databind 2.13.3
// 출처 https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.13.3

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestAPI_CodingTest_K_221008 {

    public static void main(String[] args) {
        List<List<Integer>> reservationList = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            reservationList.add(new ArrayList<>());
        }

        int dayCount = 1;

        while (dayCount < 200) {
            System.out.println();
            System.out.println();
            System.out.println("===========================================");
            System.out.println("Day Start : " + dayCount);
            RestAPI.newRequests(reservationList);

            List<Map<String, Object>> sendMapList = new ArrayList<>();

            for (Integer i : reservationList.get(dayCount)) {
                Map<String, Object> simulateMap = new HashMap<>();

                simulateMap.put("id", i);
                simulateMap.put("room_number", 1001);

                sendMapList.add(simulateMap);
            }

            Map<String, Object> data = new HashMap<>();

            data.put("room_assign", sendMapList);

            RestAPI.simulate(data);
            dayCount++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("===========================================");
            System.out.println();
            System.out.println();
        }

        RestAPI.scoreAPI();
    }

    public class RestAPI {
        static final String BASE_URL = "";
        static final String AUTH_KEY = "";

        public void startAPI(int problemNo) {
            final String EACH_REST_URL = "/start";

            HashMap<String, Object> requestMap = new HashMap<>();

            requestMap.put("problem", problemNo);    //파라미터 설정

            String rtVal = sendREST(EACH_REST_URL, "POST", makeJSON(requestMap));

            System.out.println(rtVal);
        }

        public void scoreAPI() {
            final String EACH_REST_URL = "/score";

            String rtVal = getREST(EACH_REST_URL);

            System.out.println(rtVal);
        }

        public void newRequests(List<List<Integer>> list) {
            final String EACH_REST_URL = "/new_requests";

            ObjectMapper mapper = new ObjectMapper();

            String rtVal = getREST(EACH_REST_URL);

            try {
                Map<String, Object> res = mapper.readValue(rtVal, new TypeReference<Map<String, Object>>() {
                });
                List<Map<String, Object>> rtMapList = mapper.readValue(mapper.writeValueAsString(res.get("reservations_info")), new TypeReference<List<Map<String, Object>>>() {
                });

                List<Map<String, Object>> sendMapList = new ArrayList<>();

                for (Map<String, Object> stringObjectMap : rtMapList) {
                    Integer id = (Integer) stringObjectMap.get("id");
                    Integer checkInDay = (Integer) stringObjectMap.get("check_in_date");
                    String reply = "accepted";

                    list.get(checkInDay).add(id);

                    Map<String, Object> replyMap = new HashMap<>();
                    replyMap.put("id", String.valueOf(id));
                    replyMap.put("reply", reply);

                    sendMapList.add(replyMap);
                }

                Map<String, Object> data = new HashMap<>();

                data.put("replies", sendMapList);

                reply(data);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        public void reply(Map<String, Object> map) {
            final String EACH_REST_URL = "/reply";

            String day = sendREST(EACH_REST_URL, "PUT", makeJSON(map));

            System.out.println("Cur Day : " + day);
        }

        public void simulate(Map<String, Object> map) {
            final String EACH_REST_URL = "/simulate";

            ObjectMapper mapper = new ObjectMapper();

            String rtVal = sendREST(EACH_REST_URL, "PUT", makeJSON(map));

            try {
                Map<String, Object> res = mapper.readValue(rtVal, new TypeReference<Map<String, Object>>() {
                });

                System.out.println("simulate Tomorrow Day : " + res.get("day"));
                System.out.println("simulate Fail_count : " + res.get("fail_count"));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        public String sendREST(String EACH_REST_URL, String RequestMethodStr, String jsonValue) throws IllegalStateException {
            String inputLine = null;
            StringBuilder outResult = new StringBuilder();

            try {
//            System.out.println(EACH_REST_URL + "API Start");

                URL url = new URL(BASE_URL + EACH_REST_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod(RequestMethodStr);
                if (EACH_REST_URL.equals("/start")) {
                    conn.setRequestProperty("X-Auth-Token", "");
                } else {
                    conn.setRequestProperty("Authorization", AUTH_KEY);
                }
                conn.setRequestProperty("Content-Type", "application/json");

                OutputStream os = conn.getOutputStream();
                os.write(jsonValue.getBytes(StandardCharsets.UTF_8));
                os.flush();

//            System.out.println(os);

                // 리턴된 결과 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                while ((inputLine = in.readLine()) != null) {
                    outResult.append(inputLine).append('\n');
                }

                conn.disconnect();
//            System.out.println(EACH_REST_URL + "API End");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            return outResult.toString();
        }

        public String getREST(String EACH_REST_URL) throws IllegalStateException {
            String inputLine = null;
            StringBuilder outResult = new StringBuilder();

            try {
//            System.out.println(EACH_REST_URL + "API Start");
                URL url = new URL(BASE_URL + EACH_REST_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Authorization", AUTH_KEY);
                conn.setRequestProperty("Content-Type", "application/json");

                // 리턴된 결과 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                while ((inputLine = in.readLine()) != null) {
                    outResult.append(inputLine);
                }

                conn.disconnect();
//            System.out.println(EACH_REST_URL + "API End");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            return outResult.toString();
        }

        public String makeJSON(Map<String, Object> paramMap) {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;    //convert map to JSON String(JSON으로 변환)
            try {
                json = mapper.writeValueAsString(paramMap);
                return json;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        public String makeJSON(List<Map<String, Object>> paramMap) {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;    //convert map to JSON String(JSON으로 변환)
            try {
                json = mapper.writeValueAsString(paramMap);
                return json;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
