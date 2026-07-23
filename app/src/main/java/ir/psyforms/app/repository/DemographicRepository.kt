package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.DemographicDao
import ir.psyforms.app.database.entity.DemographicEntity
import kotlinx.coroutines.flow.Flow

class DemographicRepository(
    private val demographicDao: DemographicDao
) {

    suspend fun insert(demographic: DemographicEntity): Long {
        return demographicDao.insert(demographic)
    }

    suspend fun update(demographic: DemographicEntity) {
        demographicDao.update(demographic)
    }

    suspend fun delete(demographic: DemographicEntity) {
        demographicDao.delete(demographic)
    }

    fun getAll(): Flow<List<DemographicEntity>> {
        return demographicDao.getAll()
    }

    suspend fun getBySessionId(sessionId: Long): DemographicEntity? {
        return demographicDao.getBySessionId(sessionId)
    }
}
