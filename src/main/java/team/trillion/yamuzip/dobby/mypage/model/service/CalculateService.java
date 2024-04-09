package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.CalculateMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.CalculateDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceStatusDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {
    private final CalculateMapper calculateMapper;

    // 출금 가능 수익금
    public CalculateDTO getAvailableForWithdrawal(int dobCode) {
        return calculateMapper.getAvailableForWithdrawal(dobCode);
    }

    // 출금 완료 수익금
    public CalculateDTO getWithdrawalsCompleted(int dobCode) {
        return calculateMapper.getWithdrawalsCompleted(dobCode);
    }

    // 미정산된 서비스 조회
    public List<ServiceStatusDTO> SettlementStatus(int dobCode) {
        return calculateMapper.SettlementStatus(dobCode);
    }
}
