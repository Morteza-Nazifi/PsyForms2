package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val startDateTime: Long,

    val finishDateTime: Long? = null,

    val status: Int
)
