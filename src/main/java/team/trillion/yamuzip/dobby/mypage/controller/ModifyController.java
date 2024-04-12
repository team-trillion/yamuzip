package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.trillion.yamuzip.auth.service.AuthService;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyTmpDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.WorkdayDTO;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class ModifyController {

    private final ModifyService modifyService;
    private final AuthService authenticationService;

    @Value("${profile.imageDir}")
    private String uploadDirectory;


    /* 도비 프로필 화면 이동 */
    @GetMapping("/profile")
    public String modifyUser(Model model,
                             @AuthenticationPrincipal UserDTO user){

        System.out.println("user.getUserCode() = " + user.getUserCode());
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());

        // dobCode 생성
        int dobCode = dobby.getDobCode();
        Integer dobbyCode = Integer.valueOf(dobCode);

        if(dobbyCode == 0) {
        modifyService.insertDobCode(user.getUserCode());
        }



        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
         else {
            model.addAttribute("dobby", dobby);
            model.addAttribute("workdayList", dobby.getWorkdayList().stream().map(WorkdayDTO::getDayWeek).toList());
            System.out.println(dobby);
            System.out.println(dobby.getWorkdayList());
        }
        System.out.println("dobby : " + dobby);

        return "dobby/profile";
    }


    /* 회원 정보 수정 */
    @PostMapping("/profile")
    public String modifyUser(@ModelAttribute ModifyTmpDTO modify,
                             @AuthenticationPrincipal UserDTO user,
                             Model model,
                             /* 프로필이미지 delete추가 */
                             @RequestParam(required = false)boolean profileDelete,
                             @RequestParam(required = false) MultipartFile profile) {

        System.out.println(modify);
        /* 도비 정보 수정 */

        modify.setUserCode(user.getUserCode());

        /* 도비 WORKDAY 삭제 후 수정 */

        modifyService.deleteWorkday(modify.getDobCode());
        List<String> workdayList = modify.getWorkdayList();

        for (String day : workdayList) {

            WorkdayDTO modifyWorkday = new WorkdayDTO();
            modifyWorkday.setDobCode(modify.getDobCode());
            modifyWorkday.setDayWeek(Integer.parseInt(day));

            modifyService.registWorkday(modifyWorkday);

            System.out.println("도비 영업일 삭제");
        }


        /* 도비 이미지 업로드 */
        System.out.println("도비 이미지1 : " + modify.getDobImg());

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
                model.addAttribute("dobImg", "/upload/profile-images/" + savedName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String saveFileName = "/upload/profile-images/" + savedName;
            System.out.println("도비 이미지2 : " + modify.getDobImg());
            modify.setDobImg(saveFileName);
            model.addAttribute("dobImg", modify);
        }
        if (profileDelete) {
            modify.setDobImg("removed");
        }

        modifyService.modifyDobby(modify);
        System.out.println(modify);

        SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(user.getUserId()));


        return "redirect:/dobby/profile";
    }

    protected Authentication createNewAuthentication(String userId) {

        UserDetails newPrincipal = authenticationService.loadUserByUsername(userId);
        UsernamePasswordAuthenticationToken newAuth
                = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;
    }

}

