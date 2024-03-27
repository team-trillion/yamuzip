package team.trillion.yamuzip.service.model.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import team.trillion.yamuzip.service.model.dto.*;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceDTO> findAllService();

    List<ServiceDTO> findInfoService(long serviceCode);

    List<ImageDTO> getImages();

    List<OptionDTO> getOptions(long serviceCode);

    List<ReviewDTO> getReviews(long serviceCode);

    List<CsDTO> getCs(long serviceCode);


}
