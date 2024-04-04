package team.trillion.yamuzip.login.model.dao;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Mapper
public interface UserMapper {


    UserDTO login(String userId);

    void regist(UserDTO user);


    List<String> getIds();


    List<String> findUserId(@Param("name") String name, @Param("email") String email);


    void updatePasswordByEmail(@Param("user_pwd") String encryptedPassword, @Param("email") String email);

    MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException;

    // 랜덤 인증 코드 전송
    String createKey();

    String sendSimpleMessage(String to) throws Exception;


}
