package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "responses",
    foreignKeys = [

        ForeignKey(
            entity = SessionEntity::class,
            parentColumns = ["id"],
            childColumns = ["sessionId"],
            onDelete = ForeignKey.NO_ACTION
        ),

        ForeignKey(
            entity = QuestionnaireEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionnaireId"],
            onDelete = ForeignKey.NO_ACTION
        ),

        ForeignKey(
            entity = SubscaleEntity::class,
            parentColumns = ["id"],
            childColumns = ["subscaleId"],
            onDelete = ForeignKey.NO_ACTION
        ),

        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index("sessionId"),
        Index("questionnaireId"),
        Index("subscaleId"),
        Index("questionId")
    ]
)
data class ResponseEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val sessionId: Long,

    val questionnaireId: Long,

    val subscaleId: Long,

    val questionId: Long,

    val textAnswer: String? = null,

    val numericAnswer: Double? = null,

    val optionIndex: Int? = null,

    val optionScore: Double? = null
)
