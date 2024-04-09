package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.admin.model.dto.CSDTO;

import java.util.List;

@Mapper
public interface CSMapper {
    int getCSCount();

    List<CSDTO> getCSList(SelectCriteria selectCriteria);
}
