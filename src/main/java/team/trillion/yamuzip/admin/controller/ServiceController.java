package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.admin.model.dto.ServiceDTO;
import team.trillion.yamuzip.admin.model.service.ServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/service")
public class ServiceController {

    private final ServiceService serviceService;
    private final MessageSourceAccessor messageSourceAccessor;

    public ServiceController(ServiceService serviceService, MessageSourceAccessor messageSourceAccessor) {
        this.serviceService = serviceService;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @GetMapping("/list")
    public String getServiceList(Model model) {

        List<ServiceDTO> serviceList = serviceService.findAllService();

        model.addAttribute("serviceList", serviceList);

        return "admin/service/list";
    }

    @PostMapping("/status")
    public String statusControl(@RequestParam Integer serviceCode,
                                @RequestParam String serviceStatus,
                                @RequestParam (required = false) String orderStatus,
                                RedirectAttributes rttr) {

        if (orderStatus == null) {

            Map<String, Object> serviceMap = new HashMap<>();
            serviceMap.put("serviceCode", serviceCode);
            serviceMap.put("serviceStatus", serviceStatus);
            serviceService.statusControl(serviceMap);

        } else {
            rttr.addFlashAttribute("message", messageSourceAccessor.getMessage(""));
        }
            return "redirect:/admin/service/list";
    }

}
