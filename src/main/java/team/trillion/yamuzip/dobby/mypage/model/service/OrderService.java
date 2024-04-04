package team.trillion.yamuzip.dobby.mypage.model.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.exception.CancelFailedException;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.dobby.mypage.model.dao.OrderMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderCountDTO;
import team.trillion.yamuzip.order.model.dao.PaymentMapper;
import team.trillion.yamuzip.order.model.dto.OrderRejectDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final PaymentMapper paymentMapper;

    public int getDobCode(int userCode) {
        return orderMapper.getDobCode(userCode);
    }

    public OrderCountDTO getOrderCount(int dobCode) {
        return orderMapper.getOrderCount(dobCode);
    }

    public Map<String, Object> selectAllOrderList(int dobCode, Map<String, String> searchMap, int page) {
        searchMap.put("dobCode", String.valueOf(dobCode));
        int totalCount = orderMapper.selectOrderCount(searchMap);

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

        List<OrderDTO> orderList = orderMapper.selectAllOrderList(dobCode, selectCriteria);

        Map<String, Object> orderListAndPaging = new HashMap<>();
        orderListAndPaging.put("paging", selectCriteria);
        orderListAndPaging.put("orderList", orderList);

        return orderListAndPaging;
    }

    public OrderDetailDTO selectOrderDetail(int orderCode) {
        return orderMapper.selectOrderDetail(orderCode);
    }

    @Transactional
    public void approveOrder(int orderCode) {
        orderMapper.approveOrder(orderCode);
    }

    @Transactional
    public void rejectOrder(String token, OrderRejectDTO orderReject) throws IOException {
        /* http 통신 연결해서 결제 취소 */
        HttpsURLConnection conn = null;
        URL url = new URL("https://api.iamport.kr/payments/cancel");

        conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", token);
        conn.setDoOutput(true);

        JsonObject json = new JsonObject();
        json.addProperty("reason", orderReject.getRejectReason());
        json.addProperty("merchant_uid", orderReject.getPayCode());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write(json.toString());
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        Gson gson = new Gson();
        int code = (int)Double.parseDouble((gson.fromJson(br.readLine(), Map.class).get("code").toString()));
        br.close();
        conn.disconnect();

        if(code == 0) {
            /* 결제 상태 환불 완료로 업데이트 하기 */
            paymentMapper.cancelPayment(orderReject.getPayCode());

            /* 주문 상태 거절로 업데이트 하기 */
            orderMapper.rejectOrder(orderReject);
        } else {
            throw new CancelFailedException();
        }


    }
}
