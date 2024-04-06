package team.trillion.yamuzip.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.trillion.yamuzip.login.model.dao.FindMailServiceinter;
import team.trillion.yamuzip.login.model.dao.UserMapper;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FindPwdController {

    private final FindMailServiceinter findMailServiceinter;

    @Autowired
    private UserMapper userMapper;


    public FindPwdController(FindMailServiceinter findMailServiceinter) {
        this.findMailServiceinter = findMailServiceinter;
    }


    @PostMapping("findPwd/mailConfirm")
    @ResponseBody
    String findPwd(@RequestParam("email") String email, @RequestParam("id") String id) throws Exception {


        // 서비스 불러서 아이디랑 이메일 일치하는지 체크 붕일치 에러
        Map<String, String> param = new HashMap<>();
        param.put("email", email);
        param.put("id", id);
        int result = userMapper.checkId(param);
        System.out.println("(FindPwdController) result : " + result);
        if (result != 0) {
            // 아이디랑 이메일 일치하는 값 있음

            String code = findMailServiceinter.sendSimpleMessage(email);
            System.out.println("(FindPwdController) 인증코드 :" + code);
            return code;

        } else {
            // 아이디랑 이메일 일치하는 값 없음

            // 일치하는 값이 없으니까 코드를 발생 X
            // 이메일과 아이디가 일치하지 않아서 인증할 수 없다는 메시지 or response를 front에 전달
            throw new Exception();
        }
    }

    @PostMapping("findPwd/sendPasswordResetCode")
    @ResponseBody
    public String sendPasswordResetCode(@RequestParam String email) throws Exception {
        String code = findMailServiceinter.sendPasswordResetCode(email);
        System.out.println("비밀번호 :" + code);
        userMapper.passwordNew(code);
        return code;


        // 사용자가 존재하지 않으면 에러 메시지를 반환합니다.


        // 인증 코드를 생성하고 이메일로 전송합니다.
//        String code = findMailServiceinter.sendSimpleMessage(email);

        // 코드를 bcrypt로 암호화

        // 암호화한 비밀번호를 user table에 update하면 되겠죠
        // userMapper.updateTmpPassword(code);
        // Mapper.xml > UPDATE tbl_user SET password= #{code} WHERE email = #{email}

    }
}





