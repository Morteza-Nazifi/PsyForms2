package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.ScoringRuleDao
import ir.psyforms.app.database.entity.ScoringRuleEntity
import kotlinx.coroutines.flow.Flow

class ScoringRuleRepository(
    private val scoringRuleDao: ScoringRuleDao
) {

    fun getAllScoringRules(): Flow<List<ScoringRuleEntity>> =
        scoringRuleDao.getAll()

    fun getBySubscaleId(subscaleId: Long): Flow<List<ScoringRuleEntity>> =
        scoringRuleDao.getBySubscaleId(subscaleId)

    suspend fun getByQuestionId(questionId: Long): ScoringRuleEntity? =
        scoringRuleDao.getByQuestionId(questionId)

    suspend fun getById(id: Long): ScoringRuleEntity? =
        scoringRuleDao.getById(id)

    suspend fun insert(rule: ScoringRuleEntity): Long =
        scoringRuleDao.insert(rule)

    suspend fun update(rule: ScoringRuleEntity) =
        scoringRuleDao.update(rule)

    suspend fun delete(rule: ScoringRuleEntity) =
        scoringRuleDao.delete(rule)
}
