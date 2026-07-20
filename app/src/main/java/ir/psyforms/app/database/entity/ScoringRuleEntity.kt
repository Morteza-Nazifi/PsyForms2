package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "scoring_rules",
    foreignKeys = [
        ForeignKey(
            entity = SubscaleEntity::class,
            parentColumns = ["id"],
            childColumns = ["subscaleId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("subscaleId"),
        Index("questionId")
    ]
)
data class ScoringRuleEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val subscaleId: Long,

    val questionId: Long,

    val isReverse: Boolean
)
