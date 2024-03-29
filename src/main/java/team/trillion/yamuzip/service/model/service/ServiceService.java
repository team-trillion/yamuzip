package team.trillion.yamuzip.service.model.service;

import org.springframework.stereotype.Service;
import team.trillion.yamuzip.service.model.dao.ServiceMapper;
import team.trillion.yamuzip.service.model.dto.*;

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


    public List<ServiceDTO> findInfoService(long serviceCode) {
        return serviceMapper.findInfoService(serviceCode);
    }

    public List<ImageDTO> getImages() {
        return serviceMapper.getImages();
    }

    public List<OptionDTO> getOptions(long serviceCode) {
        return serviceMapper.getOptions(serviceCode);
    }

    public List<ReviewDTO> getReviews(long serviceCode) {
        return serviceMapper.getReviews(serviceCode);
    }



    public List<CsDTO> getCs(long serviceCode) {
        return serviceMapper.getCs(serviceCode);
    }



}
