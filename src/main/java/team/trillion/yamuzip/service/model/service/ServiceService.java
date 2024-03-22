package team.trillion.yamuzip.service.model.service;

import org.springframework.stereotype.Service;
import team.trillion.yamuzip.service.model.dao.ServiceMapper;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceDTO> findAllService() {
        return serviceMapper.findAllService();
    }
}
