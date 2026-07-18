package ir.psyforms.app.data.repository

import ir.psyforms.app.domain.model.Form
import ir.psyforms.app.domain.repository.FormRepository

class FormRepositoryImpl : FormRepository {

    override suspend fun getForms(): List<Form> {
        return listOf(
            Form(
                id = 1,
                title = "نمونه فرم",
                description = "اولین فرم برنامه",
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis()
            )
        )
    }

    override suspend fun getForm(id: Long): Form? {
        return getForms().find { it.id == id }
    }

    override suspend fun insert(form: Form): Long {
        return form.id
    }

    override suspend fun update(form: Form) {
        // فعلاً پیاده‌سازی آزمایشی
    }

    override suspend fun delete(form: Form) {
        // فعلاً پیاده‌سازی آزمایشی
    }
}
