package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assessment_sessions")
data class AssessmentSessionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val createdAt: Long,

    val gender: Int,

    val age: Int,

    val educationLevel: Int,

    val fatherEducation: Int,

    val motherEducation: Int
)
