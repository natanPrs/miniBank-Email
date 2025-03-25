package com.email.models

import com.email.enums.StatusEmail
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "tb_emails")
data class EmailModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val emailFrom: String,

    val emailTo: String,

    val subject: String,

    @Column(columnDefinition = "TEXT")
    val text: String,

    val localStamp: LocalDateTime,

    var statusEmail: StatusEmail
)
