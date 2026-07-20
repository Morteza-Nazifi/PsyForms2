package ir.psyforms.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.psyforms.app.database.entity.OptionItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: OptionItemEntity): Long

    @Update
    suspend fun update(item: OptionItemEntity)

    @Delete
    suspend fun delete(item: OptionItemEntity)

    @Query(
        """
        SELECT *
        FROM option_items
        WHERE templateId = :templateId
        ORDER BY displayOrder
        """
    )
    fun getItemsByTemplate(
        templateId: Long
    ): Flow<List<OptionItemEntity>>

    @Query(
        """
        SELECT *
        FROM option_items
        WHERE id = :id
        LIMIT 1
        """
    )
    suspend fun getById(
        id: Long
    ): OptionItemEntity?
}
