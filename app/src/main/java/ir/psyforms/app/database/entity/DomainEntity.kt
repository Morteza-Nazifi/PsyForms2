package ir.psyforms.app.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "domains",
    indices = [
        Index(value = ["displayOrder"], unique = true)
    ]
)
data class DomainEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    val displayOrder: Int,

    val isActive: Boolean = true
)
