package team.trillion.yamuzip.service.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;

import java.util.List;

@Mapper
public interface ServiceMapper {
    @Select(" SELECT\n" +
            "            service_code," +
            "            dob_nickname," +
            "            service_title," +
            "            service_explain," +
            "            service_content," +
            "            service_price," +
            "            service_created" +
            "        FROM\n" +
            "            tbl_service" +
            "        JOIN tbl_dobby ON tbl_service.dob_code = tbl_dobby.dob_code" +
            "        WHERE" +
            "            service_status = 'A'" +
            "        ORDER BY" +
            "            service_code")
    @Results({
        @Result(property = "serviceCode", column = "service_code"),
        @Result(property = "dobNickName", column = "dob_nickname"),
        @Result(property = "serivceTitle", column = "service_title"),
        @Result(property = "serviceExplain", column = "service_explain"),
        @Result(property = "serviceContent", column = "service_content"),
        @Result(property = "servicePrice", column = "service_price"),
        @Result(property = "serviceCreated", column = "service_created")
})
    List<ServiceDTO> findAllService();
}
