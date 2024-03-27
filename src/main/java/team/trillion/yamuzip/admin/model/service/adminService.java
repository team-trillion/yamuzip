package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.AdminMapper;

@Slf4j
@Service
@Transactional
public class adminService {

    private final AdminMapper adminMapper;

    public adminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


}
