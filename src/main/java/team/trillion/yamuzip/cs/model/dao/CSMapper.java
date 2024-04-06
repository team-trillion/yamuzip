package team.trillion.yamuzip.cs.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.cs.model.dto.CSDTO;

import java.util.List;

@Mapper
public interface CSMapper {
    int getCSCount();

    List<CSDTO> getCSList(SelectCriteria selectCriteria);

    CSDTO getCSDetail(int csCode);

    void registCS(CSDTO cs);

    void modifyCS(CSDTO cs);

    void deleteCS(int csCode);
}
