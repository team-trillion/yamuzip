package team.trillion.yamuzip.service.controller;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import team.trillion.yamuzip.service.model.dto.*;
import team.trillion.yamuzip.service.model.service.ServiceService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller

@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;
    private final MessageSource messageSource;


    public ServiceController(ServiceService serviceService, MessageSource messageSource) {
        this.serviceService = serviceService;
        this.messageSource = messageSource;
    }

    @GetMapping("/serviceList")
    public String getServiceList(Model model) {
        List<ServiceDTO> serviceList = serviceService.getServiceList();
        List<ImageDTO> serviceImages = serviceService.getImages();

        model.addAttribute("serviceImages", serviceImages);
        model.addAttribute("serviceList", serviceList);
        return "service/serviceList";
    }

    @GetMapping("/serviceDetail/{serviceCode}")
    public String getServiceDetail(@PathVariable("serviceCode") long serviceCode, Model model) {
        ServiceDTO serviceDetailList = serviceService.getServiceDetail(serviceCode);
        List<ImageDTO> serviceImages = serviceService.getImages();
        List<OptionDTO> serviceOptions = serviceService.getOptions(serviceCode);
        List<ReviewDTO> reviews = serviceService.getReviews(serviceCode);
        List<CsDTO> cs = serviceService.getCs(serviceCode);
        model.addAttribute("serviceDetailList", serviceDetailList);
        model.addAttribute("serviceImages", serviceImages);
        model.addAttribute("serviceOptions", serviceOptions);
        model.addAttribute("reviews", reviews);
        model.addAttribute("cs", cs);
        return "service/serviceDetail";
    }

    @GetMapping("/serviceRegist")
    public String serviceRegistPage() {


        return "service/serviceRegist";
    }

    @GetMapping("/category/parentCategory")
    public @ResponseBody List<CategoryDTO> getParentCategoryList() {
        return serviceService.getParentCategoryList();
    }

    @GetMapping("category/subcategories/{parentId}")
    public @ResponseBody List<CategoryDTO> getSubcategoriesByParentId(@PathVariable Long parentId) {
        return serviceService.getSubcategoriesByParentId(parentId);
    }

    @PostMapping(value = "/serviceRegist")
    public String serviceRegist(@ModelAttribute ServiceDTO service,
                                @RequestParam(value = "serviceDetailImg", required= false ) List<MultipartFile> serviceDetailImg,
                                @RequestParam MultipartFile serviceThumbnail,
                                Model model
    ) {

        /* 이미지 업로드 */
        String root = "src/main/resources";
        String imgUrl = root + "/uploadFiles";
        File dir = new File(imgUrl);

        if (!dir.exists()) dir.mkdirs();
        List<ImageDTO> img = new ArrayList<>();

        for (MultipartFile files : serviceDetailImg) {
            String imgOriginName = files.getOriginalFilename();
            String ext = imgOriginName.substring(imgOriginName.lastIndexOf("."));
            String imgName = UUID.randomUUID() + ext;
            char section = 'S';

            try {
                files.transferTo(new File(imgUrl + "/" + imgName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            img.add(new ImageDTO(imgOriginName, imgName, "/uploadFiles/", section));

        }


        String imgOriginName = serviceThumbnail.getOriginalFilename();
        String ext = imgOriginName.substring(imgOriginName.lastIndexOf("."));
        String imgName = UUID.randomUUID() + ext;

        try {
            serviceThumbnail.transferTo(new File(imgUrl + "/" + imgName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        char section = 'S';
        long serviceCode = service.getServiceCode();

        service.setThumbnailUrl("/uploadFiles/" + imgName);
        img.add(new ImageDTO(imgOriginName, imgName, "/uploadFiles/", section));
        log.info("img : {}", img);
        log.info("service : {}", service);
        /* 서비스 등록 */
        serviceService.registService(service, img);
        model.addAttribute("message", "이미지 업로드 완료");

        return "redirect:/"; // 등록 성공 후 이동할 페이지
    }


    @GetMapping("/serviceModifyList/{serviceCode}")
    public String serviceModifyPage(@PathVariable long serviceCode, Model model) {
        ServiceDTO service = serviceService.getServiceById(serviceCode);
        List<OptionDTO> option = serviceService.getOptionById(serviceCode);
        List<ImageDTO> img = serviceService.getImagesById(serviceCode);
        System.out.println(serviceCode + "-----+++----");
        model.addAttribute("service", service);
        model.addAttribute("options", option);
        model.addAttribute("img", img);
        return "service/serviceModify"; // 수정 폼으로 이동
    }

    @PostMapping(value = "/serviceModify/{serviceCode}")
    public String serviceModify(@ModelAttribute ServiceDTO service,
                                @RequestParam(value = "imgCode",required = false) Long[] imgcode,
                                @RequestParam(value = "serviceDetailImg", required = false) List<MultipartFile> serviceDetailImg,
                                @RequestParam MultipartFile serviceThumbnail,
                                Model model) {
        /* 이미지 업로드 및 수정 */
        String root = "src/main/resources";
        String imgUrl = root + "/uploadFiles";
        File dir = new File(imgUrl);

        if (!dir.exists()) dir.mkdirs();
        List<ImageDTO> imageList = new ArrayList<>();

        // 썸네일 이미지 업로드 및 처리
        // 썸네일 이미지의 경우 이미지 코드가 필요하지 않으므로 그대로 업로드
        try {
            String thumbnailOriginName = serviceThumbnail.getOriginalFilename();
            String thumbnailExt = thumbnailOriginName.substring(thumbnailOriginName.lastIndexOf("."));
            String thumbnailImgName = UUID.randomUUID() + thumbnailExt;

            serviceThumbnail.transferTo(new File(imgUrl + "/" + thumbnailImgName));
            service.setThumbnailUrl("/uploadFiles/" + thumbnailImgName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 추가 이미지 업로드 및 처리
        if (serviceDetailImg != null && !serviceDetailImg.isEmpty()) {
            for (int i = 0; i < serviceDetailImg.size(); i++) {
                MultipartFile file = serviceDetailImg.get(i);
                Long imgCode = imgcode[i]; // 이미지 코드
                String imgOriginName = file.getOriginalFilename();
                String ext = imgOriginName.substring(imgOriginName.lastIndexOf("."));
                String imgName = UUID.randomUUID() + ext;

                char section = 'S';
                try {
                    file.transferTo(new File(imgUrl + "/" + imgName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageDTO imgDTO = new ImageDTO(imgCode, imgOriginName, imgName, "/uploadFiles/", section);
                imageList.add(imgDTO);
            }
        }

        // 이미지 정보와 함께 서비스 정보 업데이트
        serviceService.updateService(service, imageList);
        model.addAttribute("message", "서비스 수정 완료");
        log.debug("serviceDetailImg size: {}", serviceDetailImg != null ? serviceDetailImg.size() : 0);

        // 서비스 삭제

        return "redirect:/"; // 수정 성공 후 이동할 페이지
    }

    @PostMapping("/removeService/{serviceCode}")
    public String removoService( @PathVariable("serviceCode") long serviceCode) {
        serviceService.removeService(serviceCode);

        return "redirect:/";
    }



}

























