package ir.psyforms.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ir.psyforms.app.database.entity.OptionTemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionTemplateDao {

    @Insert
    suspend fun insert(optionTemplate: OptionTemplateEntity): Long

    @Update
    suspend fun update(optionTemplate: OptionTemplateEntity)

    @Delete
    suspend fun delete(optionTemplate: OptionTemplateEntity)

    @Query("SELECT * FROM option_templates ORDER BY id")
    fun getAll(): Flow<List<OptionTemplateEntity>>

    @Query("SELECT * FROM option_templates WHERE id = :id")
    suspend fun getById(id: Long): OptionTemplateEntity?
}
