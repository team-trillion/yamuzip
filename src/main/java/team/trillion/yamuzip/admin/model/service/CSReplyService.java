package team.trillion.yamuzip.admin.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CSReplyMapper;
import team.trillion.yamuzip.admin.model.dto.CSReplyDTO;

@Service
@RequiredArgsConstructor
public class CSReplyService {
    private final CSReplyMapper csReplyMapper;

    @Transactional
    public void registReply(CSReplyDTO csReply) {
        csReplyMapper.registReply(csReply);
    }

    @Transactional
    public void modifyReply(CSReplyDTO csReply) {
        csReplyMapper.modifyReply(csReply);
    }

    public void deleteReply(CSReplyDTO csReply) {
        csReplyMapper.deleteReply(csReply);
    }

    public CSReplyDTO getCSReply(int csCode) {
        return csReplyMapper.getCSReply(csCode);
    }
}
