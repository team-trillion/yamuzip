package team.trillion.yamuzip.cs.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.cs.model.dto.CSReplyDTO;

@Mapper
public interface CSReplyMapper {

    CSReplyDTO getCSReply(int csCode);

    void registReply(CSReplyDTO csReply);

    void modifyReply(CSReplyDTO csReply);

    void deleteReply(CSReplyDTO csReply);
}
