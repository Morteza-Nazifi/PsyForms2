package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.SubscaleDao
import ir.psyforms.app.database.entity.SubscaleEntity
import kotlinx.coroutines.flow.Flow

class SubscaleRepository(
    private val subscaleDao: SubscaleDao
) {

    fun getAllSubscales(): Flow<List<SubscaleEntity>> =
        subscaleDao.getAll()

    fun getSubscalesByQuestionnaire(
        questionnaireId: Long
    ): Flow<List<SubscaleEntity>> =
        subscaleDao.getByQuestionnaire(questionnaireId)

    suspend fun getById(id: Long): SubscaleEntity? =
        subscaleDao.getById(id)

    suspend fun insert(subscale: SubscaleEntity): Long =
        subscaleDao.insert(subscale)

    suspend fun update(subscale: SubscaleEntity) =
        subscaleDao.update(subscale)

    suspend fun delete(subscale: SubscaleEntity) =
        subscaleDao.delete(subscale)
}
