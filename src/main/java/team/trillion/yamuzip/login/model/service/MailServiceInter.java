package team.trillion.yamuzip.login.model.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;

public interface MailServiceInter {
    MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException;

    // 랜덤 인증 코드 전송
    String createKey();

    String sendSimpleMessage(String to) throws Exception;
}
