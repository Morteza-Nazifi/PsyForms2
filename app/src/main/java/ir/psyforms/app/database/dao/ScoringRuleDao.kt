package ir.psyforms.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.psyforms.app.database.entity.ScoringRuleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoringRuleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scoringRule: ScoringRuleEntity): Long

    @Update
    suspend fun update(scoringRule: ScoringRuleEntity)

    @Delete
    suspend fun delete(scoringRule: ScoringRuleEntity)

    @Query(
        """
        SELECT *
        FROM scoring_rules
        WHERE subscaleId = :subscaleId
        ORDER BY questionId
        """
    )
    fun getBySubscale(subscaleId: Long): Flow<List<ScoringRuleEntity>>

    @Query(
        """
        SELECT *
        FROM scoring_rules
        WHERE questionId = :questionId
        LIMIT 1
        """
    )
    suspend fun getByQuestion(questionId: Long): ScoringRuleEntity?

    @Query("DELETE FROM scoring_rules")
    suspend fun deleteAll()
}
