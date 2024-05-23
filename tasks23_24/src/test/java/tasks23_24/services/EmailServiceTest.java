package tasks23_24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void sendEmail() {
        String to = "test@example.com";
        String subject = "Test Subject";
        String text = "Test Message";

        emailService.sendEmail(to, subject, text);

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(to);
        expectedMessage.setFrom(to);
        expectedMessage.setSubject(subject);
        expectedMessage.setText(text);

        verify(mailSender).send(expectedMessage);
    }
}
