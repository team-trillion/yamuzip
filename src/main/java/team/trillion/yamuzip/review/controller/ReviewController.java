package team.trillion.yamuzip.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.auth.model.CustomUser;
import team.trillion.yamuzip.review.model.dto.ReviewDTO;

@Controller
@RequestMapping("user")
public class ReviewController {

//    @PostMapping("user/mypage/review")
//    public ResponseEntity<String> reviewWrite(ReviewDTO reviewDTO, @AuthenticationPrincipal CustomUserDetails principal){
//
//        reviewDTO.setUserId(principal.getId());
//        if (storeService.reviewWrite(reviewDTO))
//            return ResponseEntity.ok().body("리뷰 작성 완료");
//
//        return ResponseEntity.badRequest().body("파일저장 실패");
//    }



}
