package team.trillion.yamuzip.login.model.dao;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;

public interface FindMailServiceinter {

    MimeMessage createMessage(String to, String ePw) throws MessagingException, UnsupportedEncodingException;

    // 랜덤 인증 코드 전송
    String createKey();

    String sendSimpleMessage(String to) throws Exception;

    String sendPasswordResetCode(String to) throws Exception;

    MimeMessage createpsswordResetMessage(String to, String str) throws MessagingException, UnsupportedEncodingException;

}
