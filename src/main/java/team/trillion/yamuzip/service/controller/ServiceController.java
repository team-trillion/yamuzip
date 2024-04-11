package team.trillion.yamuzip.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.service.model.dto.*;
import team.trillion.yamuzip.service.model.service.ServiceService;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
        int totalService = serviceService.getTotalSerivce();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("totalService", totalService);
        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortViews")
    public String getServiceByViewsList(Model model) {
        List<ServiceDTO> serviceList =  serviceService.getServiceListSortedByViews();
        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortRecent")
    public String getServiceByRecentList(Model model) {
        List<ServiceDTO> serviceList =  serviceService.getServiceListSortedByRecent();
        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortArea")
    public String getServiceByAreaList(@RequestParam("dobArea")String area, Model model) {
        List<ServiceDTO> serviceList =  serviceService.getServiceListSortedByArea(area);
        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortWish")
    public String getServiceByWishList( Model model) {
        List<ServiceDTO> serviceList = serviceService.getServiceListSortedByWish();
        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortCareer")
    public String getServiceByCareerList(@RequestParam("dobCareerDays")String career, Model model) {
        List<ServiceDTO> serviceList;
        // 경력 범위에 따라 적절한 서비스 목록을 가져오는 서비스 메서드 호출
        if ("신입".equals(career)) {
            serviceList = serviceService.getServiceListSortedByCareerDays("신입");
        } else if ("1".equals(career)) {
            serviceList = serviceService.getServiceListSortedByCareerDays("1");
        } else if ("2".equals(career)) {
            serviceList = serviceService.getServiceListSortedByCareerDays("2");
        } else if ("3".equals(career)) {
            serviceList = serviceService.getServiceListSortedByCareerDays3y("3");
        } else {
            // 기본적으로 전체 서비스 목록을 가져오도록 설정
            serviceList = serviceService.getServiceList();
        }
        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortPrice")
    public String getServiceByPriceList(@RequestParam("servicePrice")int price, Model model) {
        List<ServiceDTO> serviceList;

            // 기본적으로 전체 서비스 목록을 가져오도록 설정
            serviceList = serviceService.getServiceListSortedByPrice(price);

        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceList/sortCategory")
    public String getServiceByCategoryList(@RequestParam("categoryCode")int category, Model model) {
        List<ServiceDTO> serviceList;

        // 기본적으로 전체 서비스 목록을 가져오도록 설정
        serviceList = serviceService.getServiceListSortedByParentCategory(category);

        model.addAttribute("serviceList", serviceList);

        return "service/serviceList";
    }
    @GetMapping("/serviceDetail")
    public String getServiceDetail(@RequestParam("serviceCode") long serviceCode, Model model) {
        ServiceDTO serviceDetailList = serviceService.getServiceDetail(serviceCode);
        List<ImageDTO> serviceImages = serviceService.getImages(serviceCode);
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

    @GetMapping("/serviceDetail/views")
    @ResponseBody
    public String getViewsCount(@RequestParam long serviceCode) {
        Integer viewsCount = serviceService.viewsCount(serviceCode);
        if (viewsCount != null) {
            return "{\"viewsCount\": " + viewsCount + "}";
        } else {
            return "{}"; // 또는 다른 적절한 오류 처리
        }
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
                           @AuthenticationPrincipal UserDTO user,
                                @RequestParam(value = "serviceDetailImg", required= false ) List<MultipartFile> serviceDetailImg,
                                @RequestParam MultipartFile serviceThumbnail,
                                Model model
    ) {
        long userCode= user.getUserCode();
       DobbyDTO dobby =  serviceService.getDobby(userCode);
       long dobCode = dobby.getDobCode();
        model.addAttribute("dobby", dobby);
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
        service.setDobCode(dobCode);
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
                                @RequestParam (value = "serviceThumbnail", required = false)MultipartFile serviceThumbnail,
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
            assert thumbnailOriginName != null;
            String thumbnailExt = "";
            if (thumbnailOriginName != null && !thumbnailOriginName.isEmpty() && thumbnailOriginName.contains(".")) {
                thumbnailExt = thumbnailOriginName.substring(thumbnailOriginName.lastIndexOf("."));
            }
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

                if (imgOriginName != null && !imgOriginName.isEmpty() && imgOriginName.contains(".")) {
                    String ext = imgOriginName.substring(imgOriginName.lastIndexOf("."));
                    String imgName = UUID.randomUUID() + ext;

                    char section = 'S';
                    try {
                        file.transferTo(new File(imgUrl + "/" + imgName));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageDTO imgDTO = new ImageDTO(imgCode, imgOriginName, imgName, "/static/uploadFiles/", section);
                    imageList.add(imgDTO);
                }

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

























