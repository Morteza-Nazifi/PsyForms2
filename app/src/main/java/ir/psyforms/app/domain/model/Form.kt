package ir.psyforms.app.domain.model

data class Form(
    val id: Long = 0,
    val title: String,
    val description: String = "",
    val createdAt: Long,
    val updatedAt: Long
)
