package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.ServiceMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceMapper serviceMapper;

    public List<ServiceDTO> getService(int dobCode) {
        return serviceMapper.getService(dobCode);
    }

}
