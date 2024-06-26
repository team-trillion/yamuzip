package team.trillion.yamuzip.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("yamuzip@gmail.com");
        javaMailSender.setPassword("yvppuwhsjtsbnygi");

        javaMailSender.setPort(587);

        javaMailSender.setJavaMailProperties(getMailPropertIes());

        return javaMailSender;
    }

    private Properties getMailPropertIes() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.starttls.trust","smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable","true");
        return properties;
    }
}

