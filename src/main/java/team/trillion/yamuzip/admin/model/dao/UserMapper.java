package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.UserDTO;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.ReviewDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<UserDTO> findAllUser();

    void banControl(Map<String, Object> banMap);

    UserDTO findBanUser(int userCode);

    List<UserDTO> findAllBanUser();

    int selectOrderCount(Map<String, String> searchMap);

    List<OrderDTO> selectAllOrderList(int userCode, SelectCriteria selectCriteria);

    List<UserDTO> findDetailUser(int userCode);

    int getReviewCount();

    List<ReviewDTO> getReviewList(int userCode, SelectCriteria selectCriteria);
}
