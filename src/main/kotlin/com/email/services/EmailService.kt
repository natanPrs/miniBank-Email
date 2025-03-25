package com.email.services

import com.email.dtos.EmailDto
import com.email.enums.StatusEmail
import com.email.models.EmailModel
import com.email.repositories.EmailRepository
import org.apache.logging.log4j.message.SimpleMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmailService(
    private val emailRepository: EmailRepository,
    private val javaMailSender: JavaMailSender
    ) {

    @Value("\${spring.mail.username}")
    lateinit var emailFrom: String

    fun sendEmail(emailDto: EmailDto): EmailModel {
        val emailModel = EmailModel(
            emailFrom = emailFrom,
            emailTo = emailDto.userEmail,
            subject = "welcome!",
            text = "welcome!!",
            localStamp = LocalDateTime.now(),
            statusEmail = StatusEmail.SEND
        )
        try {
            val message: SimpleMailMessage = SimpleMailMessage().apply {
                setTo(emailModel.emailTo)
                subject = emailModel.subject
                text = emailModel.text
            }

            javaMailSender.send(message)

        } catch (e: MailException){
            emailModel.statusEmail = StatusEmail.ERROR

        }finally {
            return emailRepository.save(emailModel)
        }
    }
}