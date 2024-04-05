package team.trillion.yamuzip.user.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dao.MypageMapper;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageMapper mypageMapper;


    // 유저 주문 정보 조회
    public OrderDTO getOrder(int userCode) {

        return mypageMapper.getOrder(userCode);
    }
}
