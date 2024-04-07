package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/list")
    public String getServiceList(Model model) {

        List<ServiceDTO> serviceList = serviceService.findAllService();

        model.addAttribute("serviceList", serviceList);

        return "admin/service/list";
    }

    @PostMapping("/status")
    public String statusControl(@RequestParam Integer serviceCode,
                                 @RequestParam String serviceStatus) {

        System.out.println(serviceCode);
        System.out.println(serviceStatus);

        Map<String, Object> serviceMap = new HashMap<>();
        serviceMap.put("serviceCode", serviceCode);
        serviceMap.put("serviceStatus", serviceStatus);
        serviceService.statusControl(serviceMap);

        return "redirect:/admin/service/list";
    }

    @GetMapping("/remove")
    public void deleteService() {}
}
