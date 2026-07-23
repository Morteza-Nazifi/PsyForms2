package ir.psyforms.app.repository

import ir.psyforms.app.database.dao.OptionTemplateItemDao
import ir.psyforms.app.database.entity.OptionTemplateItemEntity
import kotlinx.coroutines.flow.Flow

class OptionTemplateItemRepository(
    private val optionTemplateItemDao: OptionTemplateItemDao
) {

    fun getItemsByTemplateId(templateId: Long): Flow<List<OptionTemplateItemEntity>> =
        optionTemplateItemDao.getByTemplateId(templateId)

    suspend fun getById(id: Long): OptionTemplateItemEntity? =
        optionTemplateItemDao.getById(id)

    suspend fun insert(item: OptionTemplateItemEntity): Long =
        optionTemplateItemDao.insert(item)

    suspend fun update(item: OptionTemplateItemEntity) =
        optionTemplateItemDao.update(item)

    suspend fun delete(item: OptionTemplateItemEntity) =
        optionTemplateItemDao.delete(item)
}
