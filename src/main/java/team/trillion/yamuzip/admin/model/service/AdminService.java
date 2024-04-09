package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.AdminMapper;
import team.trillion.yamuzip.admin.model.dto.ChartDTO;

import java.util.List;

@Slf4j
@Service
@Transactional
public class AdminService {

    private final AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<ChartDTO> selectWeeklyRegist() {
        return adminMapper.selectWeeklyRegist();
    }
}
