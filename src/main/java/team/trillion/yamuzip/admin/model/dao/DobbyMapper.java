package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.dto.DobbyCalcDTO;
import team.trillion.yamuzip.admin.model.dto.DobbyDTO;
import team.trillion.yamuzip.admin.model.dto.DobbyServiceDTO;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;
import team.trillion.yamuzip.user.mypage.model.dto.ReviewDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface DobbyMapper {
    List<DobbyDTO> findAllDobby();

    DobbyDTO findDetailDobby(int dobCode);

    int selectServiceCount(Map<String, String> searchMap);

    List<DobbyServiceDTO> selectAllServiceList(int dobCode, SelectCriteria selectCriteria);

    int getCalcCount();

    List<DobbyCalcDTO> getCalcList(int dobCode, SelectCriteria selectCriteria);
}
