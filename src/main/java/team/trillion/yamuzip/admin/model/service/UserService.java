package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.admin.model.dao.UserMapper;
import team.trillion.yamuzip.admin.model.dto.UserDTO;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.ReviewDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
//@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDTO> findAllUser() {
        return userMapper.findAllUser();
    }

    public void banControl(Map<String, Object> banMap) {
        userMapper.banControl(banMap);
    }

    public UserDTO findBanUser(int userCode) {
        return userMapper.findBanUser(userCode);
    }

    public List<UserDTO> findAllBanUser() {
        return userMapper.findAllBanUser();
    }

    public List<UserDTO> findDetailUser(int userCode) {

        return userMapper.findDetailUser(userCode);
    }

    public Map<String, Object> selectAllOrderList(int userCode, Map<String, String> searchMap, int page) {
        searchMap.put("userCode", String.valueOf(userCode));
        int totalCount = userMapper.selectOrderCount(searchMap);

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        List<OrderDTO> orderList = userMapper.selectAllOrderList(userCode, selectCriteria);

        Map<String, Object> orderListAndPaging = new HashMap<>();
        orderListAndPaging.put("paging", selectCriteria);
        orderListAndPaging.put("orderList", orderList);

        return orderListAndPaging;
    }

    public Map<String, Object> selectAllReviewList(int userCode, int page) {
        int totalCount = userMapper.getReviewCount();

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        List<ReviewDTO> reviewList = userMapper.getReviewList(userCode, selectCriteria);

        Map<String, Object> reviewListAndPaging = new HashMap<>();
        reviewListAndPaging.put("paging", selectCriteria);
        reviewListAndPaging.put("reviewList", reviewList);

        return reviewListAndPaging;
    }
}
