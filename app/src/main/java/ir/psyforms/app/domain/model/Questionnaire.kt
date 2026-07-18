package ir.psyforms.app.domain.model

data class Questionnaire(
    val id: Long,
    val title: String,
    val description: String,
    val questionCount: Int,
)
