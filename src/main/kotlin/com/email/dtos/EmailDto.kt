package com.email.dtos

import java.util.*

data class EmailDto(
    val userId: UUID,
    val userName: String,
    val userEmail: String
)
