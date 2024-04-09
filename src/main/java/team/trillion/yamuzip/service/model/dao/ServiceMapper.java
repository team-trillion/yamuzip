package team.trillion.yamuzip.service.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.trillion.yamuzip.service.model.dto.*;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceDTO> getServiceList();

    ServiceDTO getServiceDetail(long serviceCode);

    List<ImageDTO> getImages(long serviceCode);

    List<OptionDTO> getOptions(long serviceCode);

    List<ReviewDTO> getReviews(long serviceCode);

    List<CsDTO> getCs(long serviceCode);


    void registService(ServiceDTO service);

    List<CategoryDTO> getParentCategoryList();

    List<CategoryDTO> getSubcategoriesByParentId(@Param("parentId") Long parentId);

    void uploadImg(ImageDTO img);

    void registOption(OptionDTO option);

    ServiceDTO getServiceById(long serviceCode);

    void modifyService(ServiceDTO service);

    void modifyOption(OptionDTO opt);

    void modifyImg(ImageDTO img);

    List<OptionDTO> getOptionById(long serviceCode);

    List<ImageDTO> getImagesById(long serviceCode);

    void removeService(long serviceCode);

    int viewsCount(long serviceCode);

    List<ServiceDTO> getServiceListSortedByViews();

    List<ServiceDTO> getServiceListSortedByRecent();
    List<ServiceDTO> getServiceListSortedByCareerDays(String dobCareerDays);

    List<ServiceDTO> getServiceListSortedByArea(String area);

    List<ServiceDTO> getServiceListSortedByCareerDays3y(String dobCareerDays);

    List<ServiceDTO> getServiceListSortedByPrice(int price);

    List<ServiceDTO> getServiceListSortedByParentCategory(int category);

    int getTotalService();

    void getOrderStatus(long serviceCode);
}
