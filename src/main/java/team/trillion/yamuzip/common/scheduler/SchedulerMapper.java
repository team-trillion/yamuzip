package team.trillion.yamuzip.common.scheduler;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.common.scheduler.dto.OrderDTO;

import java.util.List;

@Mapper
public interface SchedulerMapper {
    List<OrderDTO> getUntreatedOrder();

    void setOrderStatusFinish();
}
