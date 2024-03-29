package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ServiceDTO {
    private long serviceCode;
    private long dobCode;
    private DobbyDTO dobby;
    private long categoryCode;
    private String serviceTitle;
    private String serviceExplain;
    private String serviceContent;
    private int servicePrice;
    private char serviceStatus;
    private LocalDateTime serviceCreated;
    private OptionDTO option;
    private CsDTO cs;
    private CsRepDTO csRep;
    private ImageDTO image;
}
