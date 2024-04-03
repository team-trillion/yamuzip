package team.trillion.yamuzip.common.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.scheduler.dto.OrderDTO;
import team.trillion.yamuzip.order.model.dto.OrderCancelDTO;
import team.trillion.yamuzip.order.model.service.PaymentService;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerMapper schedulerMapper;
    private final PaymentService paymentService;
    private final MessageSourceAccessor messageSourceAccessor;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void cancelUntreatedOrder() {
        /* 1. status가 O이고 서비스 예약일이 오늘인 주문을 조회한다 */
        List<OrderDTO> orderList = schedulerMapper.getUntreatedOrder();

        /* 2. 각 주문에 대하여 결제와 주문을 취소한다 */
        orderList.forEach(order -> {
            try {
                String token = paymentService.getToken();
                String reason = messageSourceAccessor.getMessage("cancel.untreated");
                OrderCancelDTO orderCancel = new OrderCancelDTO();
                orderCancel.setPayCode(order.getPayCode());
                orderCancel.setOrderCode(order.getOrderCode());
                orderCancel.setCancelReason(reason);

                paymentService.cancelOrder(token, orderCancel);
                log.info("cancel untreated order");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void changeCompletedOrderStatus() {
        /* 1. 서비스 예약일이 오늘 이전이고 A 상태인 주문을 조회하여 F로 업데이트한다 */
        schedulerMapper.setOrderStatusFinish();
        log.info("change completed order status to finish");
    }
}
