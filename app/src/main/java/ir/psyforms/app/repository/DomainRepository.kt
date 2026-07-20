package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.DomainDao
import ir.psyforms.app.database.entity.DomainEntity
import kotlinx.coroutines.flow.Flow

class DomainRepository(
    private val domainDao: DomainDao
) {

    fun getAllDomains(): Flow<List<DomainEntity>> =
        domainDao.getAll()

    fun getActiveDomains(): Flow<List<DomainEntity>> =
        domainDao.getActive()

    suspend fun getById(id: Long): DomainEntity? =
        domainDao.getById(id)

    suspend fun insert(domain: DomainEntity): Long =
        domainDao.insert(domain)

    suspend fun update(domain: DomainEntity) =
        domainDao.update(domain)

    suspend fun delete(domain: DomainEntity) =
        domainDao.delete(domain)
}
