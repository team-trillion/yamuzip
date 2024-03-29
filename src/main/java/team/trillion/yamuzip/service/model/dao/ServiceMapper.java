package team.trillion.yamuzip.service.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.service.model.dto.*;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceDTO> getServiceList();

    List<ServiceDTO> getServiceDetail(long serviceCode);

    List<ImageDTO> getImages();

    List<OptionDTO> getOptions(long serviceCode);

    List<ReviewDTO> getReviews(long serviceCode);

    List<CsDTO> getCs(long serviceCode);


    void registerService(ServiceDTO service);

}
