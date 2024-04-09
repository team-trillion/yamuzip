package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.CalculateDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceStatusDTO;

import java.util.List;

@Mapper
public interface CalculateMapper {
    CalculateDTO getAvailableForWithdrawal(int dobCode);

    CalculateDTO getWithdrawalsCompleted(int dobCode);

    List<ServiceStatusDTO> SettlementStatus(int dobCode);
}
