package team.trillion.yamuzip.user.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.user.mypage.model.dto.ServiceDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecentMapper {

    public List<ServiceDTO> recentList(Map map);

    public int recentTotal();

}
