package ir.psyforms.app.ui.forms

import ir.psyforms.app.domain.model.Form

data class FormsUiState(
    val isLoading: Boolean = false,
    val forms: List<Form> = emptyList(),
    val error: String? = null
)
