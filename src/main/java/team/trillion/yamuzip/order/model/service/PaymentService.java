package team.trillion.yamuzip.order.model.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.exception.CancelFailedException;
import team.trillion.yamuzip.order.model.dao.PaymentMapper;
import team.trillion.yamuzip.order.model.dto.OrderCancelDTO;
import team.trillion.yamuzip.order.model.dto.PaymentDTO;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${imp.api.key}")
    private String impKey;

    @Value("${imp.api.secret}")
    private String impSecret;

    private final PaymentMapper paymentMapper;


    public String getToken() throws IOException {
        HttpsURLConnection conn = null;
        URL url =  new URL("https://api.iamport.kr/users/getToken");
        conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        // 요청의 Content-Type과 Accept 헤더 설정
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        // 해당 연결을 출력 스트림(요청)으로 사용
        conn.setDoOutput(true);

        // JSON 객체에 해당 API가 필요로하는 데이터 추가
        JsonObject json = new JsonObject();
        json.addProperty("imp_key", impKey);
        json.addProperty("imp_secret", impSecret);

        // 출력 스트림으로 해당 conn에 요청
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write(json.toString()); // json 객체를 문자열 형태로 HTTP 요청 본문에 추가
        bw.flush();
        bw.close();

        // 입력 스트림으로 conn 요청에 대한 응답 반환
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        Gson gson = new Gson(); // 응답 데이터를 자바 객체로 변환
        String response = gson.fromJson(br.readLine(), Map.class).get("response").toString();
        String token = gson.fromJson(response, Map.class).get("access_token").toString();

        br.close();
        conn.disconnect();

        return token;
    }

    public PaymentDTO getPaymentByOrderCode(int orderCode) {
        return paymentMapper.getPaymentByOrderCode(orderCode);
    }

    @Transactional
    public void cancelOrder(String token, OrderCancelDTO orderCancel) throws IOException {
        HttpsURLConnection conn = null;
        URL url = new URL("https://api.iamport.kr/payments/cancel");

        conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", token);
        conn.setDoOutput(true);

        JsonObject json = new JsonObject();
        json.addProperty("reason", orderCancel.getCancelReason());
        json.addProperty("merchant_uid", orderCancel.getPayCode());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write(json.toString());
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        Gson gson = new Gson(); // 응답 데이터를 자바 객체로 변환
        int code = (int)Double.parseDouble((gson.fromJson(br.readLine(), Map.class).get("code").toString()));
        br.close();
        conn.disconnect();

        if(code == 0) {
            paymentMapper.cancelPayment(orderCancel.getPayCode());
            paymentMapper.cancelOrder(orderCancel);
        } else {
            throw new CancelFailedException();
        }
    }
}
