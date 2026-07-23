package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.ResponseDao
import ir.psyforms.app.database.entity.ResponseEntity
import kotlinx.coroutines.flow.Flow

class ResponseRepository(
    private val responseDao: ResponseDao
) {

    suspend fun insert(response: ResponseEntity): Long {
        return responseDao.insert(response)
    }

    suspend fun update(response: ResponseEntity) {
        responseDao.update(response)
    }

    suspend fun delete(response: ResponseEntity) {
        responseDao.delete(response)
    }

    fun getAll(): Flow<List<ResponseEntity>> {
        return responseDao.getAll()
    }

    suspend fun getById(id: Long): ResponseEntity? {
        return responseDao.getById(id)
    }

    fun getBySession(sessionId: Long): Flow<List<ResponseEntity>> {
        return responseDao.getBySession(sessionId)
    }

    suspend fun getByQuestion(
        sessionId: Long,
        questionId: Long
    ): ResponseEntity? {
        return responseDao.getByQuestion(sessionId, questionId)
    }

    suspend fun deleteBySession(sessionId: Long) {
        responseDao.deleteBySession(sessionId)
    }
}
