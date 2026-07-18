package ir.psyforms.app.domain.model

data class Question(
    val id: Long,
    val questionnaireId: Long,
    val text: String,
    val order: Int,
)
