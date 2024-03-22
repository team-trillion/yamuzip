package team.trillion.yamuzip.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;
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

    @GetMapping("/serviceList")
    public String findAllService(Model model) {
        List<ServiceDTO> serviceList = serviceService.findAllService();

        model.addAttribute("serviceList", serviceList);
        return "search/serviceList";
    }
}
