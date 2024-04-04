package team.trillion.yamuzip.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import team.trillion.yamuzip.auth.service.AuthService;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.user.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.user.mypage.model.service.ModifyService;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class ModifyController {

    private final ModifyService modifyService;
    private final AuthService authenticationService;

    @Value("${profile.imageDir}")
    private String uploadDirectory;

    /* 회원 프로필 화면 이동 */
    @GetMapping("/profile")
    public String modifyUser() {
        return "user/mypage/profile";
    }

    /* 회원 정보 수정 */
    @PostMapping("/profile")
    public String modifyUser(String userNickname, String userName, String phone, String email,
                             @AuthenticationPrincipal UserDTO user,
                            Model model,
                            /* 프로필이미지 delete추가 */
                             @RequestParam(required = false)boolean profileDelete,
                             @RequestParam(required = false) MultipartFile profile) {

        /* 회원 정보 수정 */

        ModifyDTO modifyUser = new ModifyDTO();
        modifyUser.setUserId(user.getUserId());
        modifyUser.setUserNickname(userNickname);
        modifyUser.setUserName(userName);
        modifyUser.setPhone(phone);
        modifyUser.setEmail(email);


        /* 프로필 이미지 업로드 */

        log.info(String.valueOf(profile));
        if (profile.getSize() > 0) {
            /* 상단에 IMAGE_DIR 추가 */
            String filePath = uploadDirectory + "profile-images";
            System.out.println("filePath = " + filePath);
            String originFileName = profile.getOriginalFilename();//업로드 파일명
            String ext = originFileName.substring(originFileName.lastIndexOf("."));//업로드 파일명에서 확장자 분리
            String savedName = UUID.randomUUID() + ext;//고유한 파일명 생성 + 확장자 추가
            String finalFilePath = filePath + "/" + savedName;
            System.out.println("finalFilePath = " + finalFilePath);
            File dir = new File(filePath);
            if (!dir.exists()) dir.mkdirs();
            try {
                profile.transferTo(new File(finalFilePath));
                model.addAttribute("userImg", "/upload/profile-images/" + savedName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String saveFileName = "/upload/profile-images/" + savedName;
            modifyUser.setUserImg(saveFileName);
            model.addAttribute("modifyUser", modifyUser);
        }
        if (profileDelete) {
            modifyUser.setUserImg("removed");
        }

        modifyService.modifyUser(modifyUser);


        SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(user.getUserId()));

        log.info("회원 정보 수정 성공");

        return "redirect:/mypage";
    }

    protected Authentication createNewAuthentication(String userId) {

        UserDetails newPrincipal = authenticationService.loadUserByUsername(userId);
        UsernamePasswordAuthenticationToken newAuth
                = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;
    }

}
