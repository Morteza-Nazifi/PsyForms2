package ir.psyforms.app.domain.repository

import ir.psyforms.app.domain.model.Form

interface FormRepository {

    suspend fun getForms(): List<Form>

    suspend fun getForm(id: Long): Form?

    suspend fun insert(form: Form): Long

    suspend fun update(form: Form)

    suspend fun delete(form: Form)
}
