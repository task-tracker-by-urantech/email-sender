package com.urantech.emailsender.service;

import com.urantech.emailsender.model.EmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaListenerService {
    private final EmailService emailService;

    @KafkaListener(
            topics = "EMAIL_SENDING",
            groupId = "groupId"
    )
    public void onListen(String msg) {
        emailService.sendEmail(EmailMessage.build(msg));
    }
}
