package team.trillion.yamuzip.service.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import team.trillion.yamuzip.service.model.dao.ServiceMapper;
import team.trillion.yamuzip.service.model.dto.*;

import java.util.List;

@Service
@Transactional
public class ServiceService {
    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceDTO> getServiceList() {
        return serviceMapper.getServiceList();
    }


    public ServiceDTO getServiceDetail(long serviceCode) {
        return  serviceMapper.getServiceDetail(serviceCode);
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


    @Transactional
    public void registService(ServiceDTO service, List<ImageDTO> img) {
        serviceMapper.registService(service);
        service.getOption().forEach(opt -> {
            opt.setServiceCode(service.getServiceCode());
            serviceMapper.registOption(opt);
        });
        img.forEach(imageDTO -> {
            imageDTO.setServiceCode(service.getServiceCode());
            serviceMapper.uploadImg(imageDTO);
        });

    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getParentCategoryList() {
        return serviceMapper.getParentCategoryList();
    }


    public List<CategoryDTO> getSubcategoriesByParentId(long parentId) {
        return serviceMapper.getSubcategoriesByParentId(parentId);
    }


    public ServiceDTO getServiceById(long serviceCode) {
        return serviceMapper.getServiceById(serviceCode);
    }

    @Transactional
    public void updateService(ServiceDTO service, List<ImageDTO> img) {
        serviceMapper.modifyService(service);
        service.getOption().forEach(opt -> {
            //insert delete update 걸러내기
            serviceMapper.modifyOption(opt);
            System.out.println(opt+"----------###");
        });
        img.forEach(imageDTO -> {
            serviceMapper.modifyImg(imageDTO);
            System.out.println(imageDTO+"===========================");
        });
    }


    public List<OptionDTO> getOptionById(long serviceCode) {
        return serviceMapper.getOptionById(serviceCode);
    }
    public List<ImageDTO> getImagesById(long serviceCode) {
        return serviceMapper.getImagesById(serviceCode);
    }

    public void removeService(long serviceCode) {

        serviceMapper.removeService(serviceCode);
    }
}


