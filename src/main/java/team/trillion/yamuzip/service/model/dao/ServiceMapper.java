package team.trillion.yamuzip.service.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import team.trillion.yamuzip.service.model.dto.*;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceDTO> findAllService();

    List<ServiceDTO> findInfoService();

    List<ImageDTO> getImages();

    List<OptionDTO> getOptions();

    List<ReviewDTO> getReviews();

    List<CsDTO> getCs();
}
