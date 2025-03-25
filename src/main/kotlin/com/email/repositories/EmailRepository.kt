package com.email.repositories

import com.email.models.EmailModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EmailRepository : JpaRepository<EmailModel, UUID> {
}