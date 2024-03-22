package team.trillion.yamuzip.service.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ServiceDTO {
    private long serviceCode;
    private long dobCode;
    private int categoryCode;
    private String serviceTitle;
    private String serviceExplain;
    private String serviceContent;
    private int servicePrice;
    private char serviceStatus;
    private LocalDateTime serviceCreated;
    private DobbyDTO dobbyDTO;

}
