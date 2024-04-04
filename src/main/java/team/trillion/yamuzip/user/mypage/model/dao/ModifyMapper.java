package team.trillion.yamuzip.user.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.user.mypage.model.dto.ModifyDTO;

@Mapper
public interface ModifyMapper {

    void modifyUser(ModifyDTO modifyUser);

    void modifyImg(ModifyDTO userImg);
}
