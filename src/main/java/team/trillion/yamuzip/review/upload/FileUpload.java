package team.trillion.yamuzip.review.upload;

import org.springframework.stereotype.Component;
import team.trillion.yamuzip.review.model.dto.ReviewDTO;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class FileUpload {

    public boolean uploadReviewImg(ReviewDTO reviewDTO) {


        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String uploadForder= Paths.get("C:", "delivery", "upload").toString();
        String imageUploadForder = Paths.get("reviewImg", today).toString();
        String uploadPath = Paths.get(uploadForder, imageUploadForder).toString();

        File dir = new File(uploadPath);
        if (dir.exists() == false) {
            dir.mkdirs();
        }


        UUID uuid = UUID.randomUUID();
        String reviewImgName = uuid+"_"+reviewDTO.getFile().getOriginalFilename();


        try {
            File target = new File(uploadPath, reviewImgName);
            reviewDTO.getFile().transferTo(target);

        } catch (Exception e) {
            return false;
        }


        reviewDTO.setReviewImg("upload\\"+imageUploadForder+"\\"+reviewImgName);


        return true;
    }
}
