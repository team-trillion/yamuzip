package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.UserDTO;
import team.trillion.yamuzip.admin.model.dto.UserOrderDTO;
import team.trillion.yamuzip.admin.model.dto.UserReviewDTO;
import team.trillion.yamuzip.admin.model.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getUserList(Model model) {

        List<UserDTO> userList = userService.findAllUser();

        model.addAttribute("userList", userList);

        return "admin/user/list";
    }

    @GetMapping("/detail")
    public String getUserDetail(@RequestParam int userCode,
                                Model model) {

        List<UserDTO> userInfo = userService.findDetailUser(userCode);

        model.addAttribute("userInfo", userInfo);

        return "admin/user/detail";
    }

    @GetMapping("/banList")
    public String getBanList(Model model) {

        List<UserDTO> banUserList = userService.findAllBanUser();

        model.addAttribute("banUserList", banUserList);

        return "admin/user/banList";
    }

    @PostMapping("/ban")
    public String banControl(@RequestParam Integer userCode,
                             @RequestParam String userStatus,
                             @RequestParam (required = false) LocalDateTime unban) {

        System.out.println(userCode);
        System.out.println(userStatus);

        if (unban == null) {
            unban = LocalDateTime.now().plusYears(1);
        }

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        return "redirect:/admin/user/ban?userCode=" + userCode + "&userStatus=" + userStatus + "&unban=" + unban;
    }

    @GetMapping("/ban")
    public String banUser(@RequestParam Integer userCode,
                          @RequestParam String userStatus,
                          @RequestParam (required = false) LocalDateTime unban,
                          Model model) {

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        UserDTO userInfo = userService.findBanUser(userCode);
        model.addAttribute("userInfo", userInfo);
        System.out.println(userInfo);

        return "admin/user/ban";

    }

    @PostMapping("/banModify")
    public String banModifyControl(@RequestParam Integer userCode,
                                   @RequestParam String userStatus,
                                   @RequestParam (required = false) LocalDateTime unban) {

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        return "redirect:/admin/user/banList";
    }

    @GetMapping("/detailOrder")
    public String getUserOrder(@RequestParam int userCode,
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

        Map<String, Object> orderListAndPaging = userService.selectAllOrderList(userCode, searchMap, page);
        model.addAttribute("paging", orderListAndPaging.get("paging"));

        List<UserOrderDTO> orderList = (List<UserOrderDTO>) orderListAndPaging.get("orderList");
        for(UserOrderDTO order : orderList) {
            order.setOrderDateString(order.getOrderDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        List<UserDTO> userInfo = userService.findDetailUser(userCode);

        model.addAttribute("userCode", userCode);
        model.addAttribute("orderList", orderList);
        model.addAttribute("userInfo", userInfo);

        return "admin/user/detailOrder";
    }

    @GetMapping("/detailReview")
    public String getUserReview(@RequestParam int userCode,
                               @RequestParam(defaultValue = "1") int page,
                               Model model) {

        Map<String, Object> reviewListAndPaging = userService.selectAllReviewList(userCode, page);
        model.addAttribute("paging", reviewListAndPaging.get("paging"));

        List<UserReviewDTO> reviewList = (List<UserReviewDTO>) reviewListAndPaging.get("reviewList");
        for(UserReviewDTO review : reviewList) {
            review.setReviewDateString(review.getReviewCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        List<UserDTO> userInfo = userService.findDetailUser(userCode);

        model.addAttribute("userCode", userCode);
        model.addAttribute("reviewList", reviewList);
        model.addAttribute("userInfo", userInfo);

        return "admin/user/detailReview";
    }

}
