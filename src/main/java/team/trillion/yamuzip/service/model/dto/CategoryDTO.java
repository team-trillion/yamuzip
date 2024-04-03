package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CategoryDTO {

    private long categoryCode;
    private String categoryName;
    private long refCategoryCode;

}
