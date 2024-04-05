package team.trillion.yamuzip.login.model.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.login.model.dao.FindMailServiceinter;
import team.trillion.yamuzip.login.model.dao.UserMapper;

import java.io.UnsupportedEncodingException;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class FindPwdResetMail implements FindMailServiceinter {


    private final JavaMailSender emailSender;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public MimeMessage createMessage(String to, String ePw) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = emailSender.createMimeMessage();


        message.addRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject("YAMUZIP 비밀번호찾기 인증코드 이메일 입니다.");

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> YAMUZIP 입니다.</h1>";
        msgg += "<br>";
        msgg += "<p>아래 비밀번호를 비밀번호 찾기 창으로 돌아가 입력해주세요<p>";
        msgg += "<br>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'> 비밀번호 코드  입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += ePw + "</strong><div><br/> "; // 메일에 인증번호 넣기
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");// 내용, charset 타입, subtype
        // 보내는 사람의 이메일 주소, 보내는 사람 이름
        message.setFrom(new InternetAddress("yamuzip@gmail.com", "YAMUZIP_Admin"));// 보내는 사람

        return message;
    }


    @Override
    public String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(3);

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    // a~z (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    // A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }

        }
        return key.toString();
    }

    @Override
    public String sendSimpleMessage(String to) throws Exception {

        String ePw = createKey(); // 랜덤 인증번호 생성

        // TODO Auto-generated method stub
        MimeMessage message = createMessage(to, ePw); // 메일 발송
        try {// 예외처리
            emailSender.send(message);

        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        /* 1. 위에서 받아온 ePw를 암호화한다 */
        /* 2. userMapper의 updateTmpPassword(ePw) 메소드를 호출해서 DB의 비밀번호를 업데이트 한다 */
        return ePw; // 메일로 보냈던 인증 코드를 서버로 반환
    }

    // 추가적으로 비밀번호 재설정 관련 메서드 구현...
    public static String getTempPassword() {
        char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        System.out.println("생성된문자열: " + str);
        return str;
    }


    @Override
    public String sendPasswordResetCode(String to) throws Exception {
        String str = getTempPassword(); // 임시 비밀번호 생성
        // 생성된 임시 비밀번호를 포함한 이메일 생성 및 전송
        MimeMessage message = createpsswordResetMessage(to, str);
        try {
            emailSender.send(message);
        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException();
        }

        // 임시 비밀번호로 사용자의 비밀번호 업데이트
        updatePassword(str, to);
        System.out.println("sendPasswordResetCode" + str);


        return str; // 생성된 임시 비밀번호 반환

    }

    private void updatePassword(String newPassword, String email) {
        try {
            String encryptedPassword = passwordEncoder.encode(newPassword);
            userMapper.updatePasswordByEmail(encryptedPassword, email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to update password in the database.");
        }
    }


    @Override
    public MimeMessage createpsswordResetMessage(String to, String str) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = emailSender.createMimeMessage();


        message.addRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject("YAMUZIP 비밀번호찾기 임시비밀번호 이메일 입니다.");

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> YAMUZIP 입니다.</h1>";
        msgg += "<br>";
        msgg += "<p>아래 비밀번호를 비밀번호 찾기 창으로 돌아가 입력해주세요<p>";
        msgg += "<br>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'> 임시 비밀번호  입니다.</h3>";
        msgg += "<h3 style='color:blue;'> 로그인 후 비밀번호를 변경해주세요.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += str + "</strong><div><br/> "; // 메일에 인증번호 넣기
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");// 내용, charset 타입, subtype
        // 보내는 사람의 이메일 주소, 보내는 사람 이름
        message.setFrom(new InternetAddress("yamuzip@gmail.com", "YAMUZIP_Admin"));// 보내는 사람

        return message;
    }

}

