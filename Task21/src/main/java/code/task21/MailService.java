package code.task21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    void sendEmail(String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("nikis16042004@gmail.com");

        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);
        log.info("Sended mail with text: " + text);
    }
}
