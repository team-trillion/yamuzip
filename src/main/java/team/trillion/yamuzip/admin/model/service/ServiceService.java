package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.ServiceMapper;
import team.trillion.yamuzip.admin.model.dto.ServiceDTO;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class ServiceService {

    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceDTO> findAllService() {
        return serviceMapper.findAllService();
    }

    public void statusControl(Map<String, Object> serviceMap) {
        serviceMapper.statusControl(serviceMap);
        System.out.println(serviceMap);
    }
}
