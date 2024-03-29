package team.trillion.yamuzip.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.service.model.dto.*;
import team.trillion.yamuzip.service.model.service.ServiceService;

import java.util.List;

@Slf4j
@Controller
public class ServiceController {

    private final ServiceService serviceService;
    private final MessageSource messageSource;

    public ServiceController(ServiceService serviceService, MessageSource messageSource) {
        this.serviceService = serviceService;
        this.messageSource = messageSource;
    }

    @GetMapping("/search/serviceList")
    public String findAllService(Model model) {
        List<ServiceDTO> serviceList = serviceService.findAllService();
        List<ImageDTO> serviceImages = serviceService.getImages();

        model.addAttribute("serviceImages", serviceImages);
        model.addAttribute("serviceList", serviceList);
        return "search/serviceList";
    }

    @GetMapping("/service/serviceInfo/{serviceCode}")
    public String findInfoService(@PathVariable("serviceCode") long serviceCode, Model model) {
        List<ServiceDTO> serviceInfoList = serviceService.findInfoService(serviceCode);


        List<ImageDTO> serviceImages = serviceService.getImages();
        List<OptionDTO> serviceOptions = serviceService.getOptions(serviceCode);
        List<ReviewDTO> reviews = serviceService.getReviews(serviceCode);
        List<CsDTO> cs = serviceService.getCs(serviceCode);
        model.addAttribute("serviceInfoList", serviceInfoList);
        model.addAttribute("serviceImages", serviceImages);
        model.addAttribute("serviceOptions", serviceOptions);
        model.addAttribute("reviews", reviews);
        model.addAttribute("cs", cs);
        return "service/serviceInfo";
    }

    @GetMapping("/service/serviceRegist")
    public String serviceRegistPage(Model model) {


        return "service/serviceRegist";
    }

    @PostMapping(value = "/service/serviceRegist")
    public String serviceRegist(@RequestParam String title,
                                @RequestParam String explain,
                                @RequestParam String content,
                                @RequestParam int price,
                                @RequestParam ImageDTO thumbnail) {
        ServiceDTO service = new ServiceDTO();
        service.setServiceTitle(title);
        service.setServiceExplain(explain);
        service.setServiceContent(content);
        service.setServicePrice(price);
        service.setImage(thumbnail);

        serviceService.registerService(service);

        return "redirect:/"; // 등록 성공 후 이동할 페이지
    }
}
