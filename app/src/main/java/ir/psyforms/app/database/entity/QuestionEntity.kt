package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions",
    foreignKeys = [
        ForeignKey(
            entity = SubscaleEntity::class,
            parentColumns = ["id"],
            childColumns = ["subscaleId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = OptionTemplateEntity::class,
            parentColumns = ["id"],
            childColumns = ["optionTemplateId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("subscaleId"),
        Index("optionTemplateId")
    ]
)
data class QuestionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val subscaleId: Long,

    val title: String,

    val questionType: Int,

    val displayOrder: Int,

    val optionTemplateId: Long?,

    val reverseScoring: Boolean
)
