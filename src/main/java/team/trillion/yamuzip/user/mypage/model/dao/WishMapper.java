package team.trillion.yamuzip.user.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.user.mypage.model.dto.WishDTO;

import java.util.List;

@Mapper
public interface WishMapper {

    List<WishDTO> getWish(int userCode);
}
