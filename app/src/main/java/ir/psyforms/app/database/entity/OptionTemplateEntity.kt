package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "option_templates")
data class OptionTemplateEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)
