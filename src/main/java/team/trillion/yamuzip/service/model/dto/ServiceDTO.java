package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
public class ServiceDTO {
    private long serviceCode;
    private long dobCode;
    private String dobArea;
    private String dobCreerDays;
    private DobbyDTO dobby;
    private CategoryDTO category;
    private int categoryCode;
    private String serviceTitle;
    private String serviceExplain;
    private String serviceContent;
    private int servicePrice;
    private char serviceStatus;
    private LocalDateTime serviceCreated;
    private List<OptionDTO> option;
    private CsDTO cs;
    private CsRepDTO csRep;
    private ImageDTO image;
    private String thumbnailUrl;
    private int views;


}
