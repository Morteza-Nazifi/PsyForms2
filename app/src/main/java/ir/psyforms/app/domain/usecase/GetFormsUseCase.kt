package ir.psyforms.app.domain.usecase

import ir.psyforms.app.domain.model.Form
import ir.psyforms.app.domain.repository.FormRepository

class GetFormsUseCase(
    private val repository: FormRepository
) {

    suspend operator fun invoke(): List<Form> {
        return repository.getForms()
    }

}
