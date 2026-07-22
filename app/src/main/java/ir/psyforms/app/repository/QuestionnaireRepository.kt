package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.QuestionnaireDao
import ir.psyforms.app.database.entity.QuestionnaireEntity
import kotlinx.coroutines.flow.Flow

class QuestionnaireRepository(
    private val questionnaireDao: QuestionnaireDao
) {

    fun getAllQuestionnaires(): Flow<List<QuestionnaireEntity>> =
        questionnaireDao.getAll()

    fun getActiveQuestionnaires(): Flow<List<QuestionnaireEntity>> =
        questionnaireDao.getActive()

    fun getQuestionnairesByDomain(domainId: Long): Flow<List<QuestionnaireEntity>> =
        questionnaireDao.getByDomain(domainId)

    fun getActiveQuestionnairesByDomain(domainId: Long): Flow<List<QuestionnaireEntity>> =
        questionnaireDao.getActiveByDomain(domainId)

    suspend fun getById(id: Long): QuestionnaireEntity? =
        questionnaireDao.getById(id)

    suspend fun insert(questionnaire: QuestionnaireEntity): Long =
        questionnaireDao.insert(questionnaire)

    suspend fun update(questionnaire: QuestionnaireEntity) =
        questionnaireDao.update(questionnaire)

    suspend fun delete(questionnaire: QuestionnaireEntity) =
        questionnaireDao.delete(questionnaire)
}
