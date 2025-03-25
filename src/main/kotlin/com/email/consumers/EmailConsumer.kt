package com.email.consumers

import com.email.dtos.EmailDto
import com.email.services.EmailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer(private val emailService: EmailService) {

    @RabbitListener(queues = ["\${broker.queue.email.name}"])
    fun listenEmailQueue(@Payload emailDto: EmailDto) {
        emailService.sendEmail(emailDto)
    }
}