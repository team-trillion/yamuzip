package team.trillion.yamuzip.user.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.OrderStatusMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderStatusDTO;
import team.trillion.yamuzip.user.mypage.model.dao.WishMapper;
import team.trillion.yamuzip.user.mypage.model.dto.WishDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WistService {
    private final WishMapper wishMapper;

    public List<WishDTO> getWish(int userCode) {

        return wishMapper.getWish(userCode);
    }
}
