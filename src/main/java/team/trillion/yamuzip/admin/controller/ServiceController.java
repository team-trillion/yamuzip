package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.ServiceDTO;
import team.trillion.yamuzip.admin.model.service.ServiceService;

import java.util.List;

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

    @GetMapping("/detail")
    public void getServiceDetail() {}

    @GetMapping("/hide")
    public void hideService() {}

    @GetMapping("/open")
    public void openService() {}

    @GetMapping("/delete")
    public void deleteService() {}
}
