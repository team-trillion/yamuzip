package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.*;
import team.trillion.yamuzip.admin.model.service.DobbyService;
import team.trillion.yamuzip.admin.model.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/admin/dobby")
public class DobbyController {

    private final DobbyService dobbyService;
    private final UserService userService;

    public DobbyController(DobbyService dobbyService, UserService userService) {
        this.dobbyService = dobbyService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getDobbyList(Model model) {

        List<DobbyDTO> dobbyList = dobbyService.findAllDobby();

        model.addAttribute("dobbyList", dobbyList);

        return "admin/dobby/list";
    }

    @GetMapping("/detail")
    public String getDobbyDetail(@RequestParam int userCode,
                                 Model model) {

        List<UserDTO> userDetail = userService.findDetailUser(userCode);

        model.addAttribute("userDetail", userDetail);

        return "admin/dobby/detail";
    }

    @GetMapping("/detailService")
    public String getDobbyService(@RequestParam int dobCode,
                               @RequestParam int userCode,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(required = false) String start,
                               @RequestParam(required = false) String end,
                               @RequestParam(required = false) String searchCondition,
                               @RequestParam(required = false) String searchValue,
                               Model model) {

        Map<String, String> searchMap = new HashMap<>();
        if(searchCondition == null && !Objects.equals(searchValue, "") && searchValue != null)
            searchCondition = "serviceTitle";
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("start", start);
        searchMap.put("end", end);

        Map<String, Object> serviceListAndPaging = dobbyService.selectAllServiceList(dobCode, searchMap, page);
        model.addAttribute("paging", serviceListAndPaging.get("paging"));

        List<DobbyServiceDTO> serviceList = (List<DobbyServiceDTO>) serviceListAndPaging.get("serviceList");
        for(DobbyServiceDTO service : serviceList) {
            service.setServiceDateString(service.getServiceCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        List<UserDTO> usersInfo = userService.findDetailUser(userCode);

        model.addAttribute("dobCode", dobCode);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("usersInfo", usersInfo);

        return "admin/dobby/detailService";
    }

    @GetMapping("/detailCalc")
    public String getUserReview(@RequestParam int dobCode,
                                @RequestParam int userCode,
                                @RequestParam(defaultValue = "1") int page,
                                Model model) {

        Map<String, Object> calcListAndPaging = dobbyService.selectAllCalcList(dobCode, page);
        model.addAttribute("paging", calcListAndPaging.get("paging"));

        List<DobbyCalcDTO> calcList = (List<DobbyCalcDTO>) calcListAndPaging.get("calcList");
        for(DobbyCalcDTO calc : calcList) {
            calc.setPayDateString(calc.getPayDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        List<UserDTO> usersInfo = userService.findDetailUser(userCode);

        model.addAttribute("dobCode", dobCode);
        model.addAttribute("calcList", calcList);
        model.addAttribute("usersInfo", usersInfo);

        return "admin/dobby/detailCalc";
    }
}
