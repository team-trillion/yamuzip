package team.trillion.yamuzip.order.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ServiceDTO {

    private int serviceCode;
    private int dobCode;
    private DobbyDTO dobby;
    private int categoryCode;
    private CategoryDTO category;
    private String serviceTitle;
    private String serviceExplain;
    private String serviceContent;
    private int servicePrice;
    private char serviceStatus;
    private LocalDateTime serviceCreated;
    private List<ImageDTO> imageList;
    private List<OptionDTO> optionList;
    // private List<LocalDateTime> reserveDatetimeList;
    private List<OrderDTO> orderList;

}
