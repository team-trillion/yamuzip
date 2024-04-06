package team.trillion.yamuzip.user.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;

@Mapper
public interface MypageMapper {

    OrderDTO getOrder(int userCode);
}
