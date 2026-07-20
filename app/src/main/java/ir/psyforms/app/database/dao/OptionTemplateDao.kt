package ir.psyforms.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.psyforms.app.database.entity.OptionTemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionTemplateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(template: OptionTemplateEntity): Long

    @Update
    suspend fun update(template: OptionTemplateEntity)

    @Delete
    suspend fun delete(template: OptionTemplateEntity)

    @Query(
        """
        SELECT *
        FROM option_templates
        ORDER BY id
        """
    )
    fun getAll(): Flow<List<OptionTemplateEntity>>

    @Query(
        """
        SELECT *
        FROM option_templates
        WHERE id = :id
        LIMIT 1
        """
    )
    suspend fun getById(id: Long): OptionTemplateEntity?
}
