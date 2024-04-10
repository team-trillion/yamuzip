package team.trillion.yamuzip.service.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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



    public List<ImageDTO> getImages(long serviceCode) {
        return serviceMapper.getImages(serviceCode);
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
//        if (!isValidProductName(service.getServiceTitle())) {
//            throw new IllegalArgumentException("서비스 제목에 특수 문자를 포함할 수 없습니다.");
//        }
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

    private boolean isValidProductName(String serviceTitle) {
        // 특수 문자를 포함하지 않는지 확인하는 정규 표현식
        String regex = "^[a-zA-Z0-9ㄱ-ㅎ가-힣\\s]*$";

        // 정규 표현식에 맞는지 검사
        return serviceTitle.matches(regex);
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

        serviceMapper.getOrderStatus(serviceCode);

        serviceMapper.removeService(serviceCode);
    }



    public int viewsCount(long serviceCode) {
        return serviceMapper.viewsCount(serviceCode);

    }

    public List<ServiceDTO> getServiceListSortedByViews( ) {
        return serviceMapper.getServiceListSortedByViews();
    }

    public List<ServiceDTO> getServiceListSortedByRecent() {
        return serviceMapper.getServiceListSortedByRecent();
    }
    public List<ServiceDTO> getServiceListSortedByCareerDays(String dobCareerDays) {
        return serviceMapper.getServiceListSortedByCareerDays(dobCareerDays);
    }

    public List<ServiceDTO> getServiceListSortedByArea(String area) {
        return serviceMapper.getServiceListSortedByArea(area);
    }

    public List<ServiceDTO> getServiceListSortedByCareerDays3y(String dobCareerDays ) {
        return serviceMapper.getServiceListSortedByCareerDays3y(dobCareerDays);
    }

    public List<ServiceDTO> getServiceListSortedByPrice(int price) {

        return serviceMapper.getServiceListSortedByPrice(price);
    }

    public List<ServiceDTO> getServiceListSortedByParentCategory(int category) {
        return serviceMapper.getServiceListSortedByParentCategory(category);
    }

    public int getTotalSerivce() {

        return serviceMapper.getTotalService();
    }

    public DobbyDTO getDobby(long userCode) {

        return serviceMapper.getDobby(userCode);
    }

    public void likeService(Long serviceCode, long userCode) {
        serviceMapper.likeService(serviceCode,userCode);
    }

    public void unlikeService(Long serviceCode, long userCode) {
        serviceMapper.unlikeService(serviceCode, userCode);
    }

    public List<ServiceDTO> getServiceListSortedByWish() {
       return serviceMapper.getServiceListSortedByWish();
    }
}


