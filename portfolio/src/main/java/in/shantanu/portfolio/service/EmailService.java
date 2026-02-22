package in.shantanu.portfolio.service;

import in.shantanu.portfolio.model.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("shantanu.officialwork@gmail.com");
        message.setSubject("New Portfolio Contact Message");

        message.setText(
                "Name: " + request.getName() + "\n" +
                        "Email: " + request.getEmail() + "\n\n" +
                        "Message:\n" + request.getMessage()
        );

        mailSender.send(message);
    }
}
