package team.trillion.yamuzip.notice.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int getNoticeCount();
    List<NoticeDTO> getNoticeList(SelectCriteria selectCriteria);

    void incrementNoticeHits(int noticeCode);

    NoticeDTO getNoticeDetail(int noticeCode);

    void registNotice(NoticeDTO notice);

    void modifyNotice(NoticeDTO notice);

    void deleteNotice(int noticeCode);

    List<NoticeDTO> getFixedList();
}
