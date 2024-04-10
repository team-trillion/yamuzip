package team.trillion.yamuzip.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.service.model.service.ServiceService;

@RestController
public class LikeController {

    private final ServiceService serviceService;

    @Autowired
    public LikeController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/likeService")
    public ResponseEntity<String> likeService(@RequestParam("serviceCode") Long serviceCode,
                                              @AuthenticationPrincipal UserDTO user) {
        try {
            serviceService.likeService(serviceCode, user.getUserCode());
            return ResponseEntity.ok("Service liked successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to like service.");
        }
    }

    @PostMapping("/unlikeService")
    public ResponseEntity<String> unlikeService(@RequestParam("serviceCode") Long serviceCode,
                                                @AuthenticationPrincipal UserDTO user) {
        try {
            serviceService.unlikeService(serviceCode, user.getUserCode());
            return ResponseEntity.ok("Service unliked successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to unlike service.");
        }
    }
}
